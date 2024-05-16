package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JTextField;

import model.SimpleAudioPlayer;
import view.Panello;



public class Controller implements ActionListener{
	
	
	static String fileIntermezzo =  "canzone.txt";
	static String filebuffer = "inesec.txt";
	static String filePath; 
	SimpleAudioPlayer audioPlayer = null;
	
	private Panello pannello;
	
public Controller(Panello pannello) {
		
		this.pannello = pannello;
		pannello.registraEvento(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	
        // DOWNLOAD
		
		if(e.getActionCommand().equals("VAI")) {
		    JTextField field = pannello.getLink();
		    
		    if(field.getText().equals("")) {
		        System.out.println("Inserisci un link");
		        pannello.noLink();
		    } else {
		        try {
		            FileWriter writer = new FileWriter(fileIntermezzo);
		            writer.write(field.getText());
		            writer.close();
		            System.out.println("Scrittura completata sul file: " + fileIntermezzo);
		        } catch (IOException e1) {
		            System.out.println("Si è verificato un errore durante la scrittura sul file.");
		            e1.printStackTrace();
		        }
		        
		 
		        Thread timerThread = new Thread(() -> {        // Creazione e avvio del thread con timer
		            long startTime = System.currentTimeMillis();
		            
		            
		            try {
		                ProcessBuilder pb = new ProcessBuilder("python", "scarica.py");
		                Process process = pb.start();
		                
		                
		                // Prendo l'output dello script
		                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		                String line;
		                while ((line = reader.readLine()) != null) {
		                    System.out.println(line);
		                }
		                
		                // Aspetto che lo script finisca
		                int exitCode = process.waitFor();
		                long endTime = System.currentTimeMillis();
		                long elapsedTime = endTime - startTime;
		                double elapsedTimeInSeconds = elapsedTime / 1000.0; // Conversione da millisecondi a secondi
		                System.out.println("Python script exited with code " + exitCode);
		                System.out.println("Elapsed time: " + elapsedTimeInSeconds + " seconds");
		                
		            } catch (IOException | InterruptedException e1) {
		                e1.printStackTrace();
		            }
		        });
		        
		        
		        timerThread.start(); // Avvio del thread
		    }
		}

		
				 
				 
		         
		// PLAY THE SONG
		
		
		
		if(e.getActionCommand().equals("Play")) {
			
			
			 Thread playThread = new Thread(() -> {
				 
			String nomeFile = "music_downloader.txt";
	        StringBuilder contenutoFile = new StringBuilder();
	        

	        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
	            String riga;
	            while ((riga = reader.readLine()) != null) {
	                contenutoFile.append(riga); // Aggiunge la riga al contenuto con un newline
	            }
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }

	       
	        
	
            
	        String contenuto = contenutoFile.toString() + ".wav";

	        
			
			
			try {
				filePath = contenuto;
				audioPlayer = new SimpleAudioPlayer(filePath);
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
            
			
			
			
			if(audioPlayer!=null) {
				
				audioPlayer.play(); 
				System.out.println("The song is playing");
				pannello.disabilitaPlay();
				pannello.abilitaStop();
			}
			else {
				
				System.out.println("c'è stato un errore");
			}
			
				 
			 	
			 });
			 
			 
			 playThread.start();
			 
			 
		}
		
		
		if(e.getActionCommand().equals("STOP"))  {
			
			
				try {
					audioPlayer.stop();
					pannello.abilitaPlay();
					pannello.disabilitaStop();
					System.out.println("The song has been stopped");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
	
		       
		}
		
		
	

	

}
	

