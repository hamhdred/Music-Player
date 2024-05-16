from yt_dlp import YoutubeDL
import os

# YouTube video URL
with open("canzone.txt", "r") as file:
    url = file.readline().strip()  # Legge la prima riga del file e rimuove eventuali spazi bianchi


# Download options
ydl_opts = {
    'format': 'bestaudio/best',
    'postprocessors': [{
        'key': 'FFmpegExtractAudio',
        'preferredcodec': 'wav',
        'preferredquality': '192',
    }],
    'outtmpl': './%(title)s.%(ext)s',
}

with YoutubeDL(ydl_opts) as ydl:
    ydl.download([url])
    info_dict = ydl.extract_info(url, download=False)
    file_name_ = ydl.prepare_filename(info_dict)

   
song_name = os.path.splitext(file_name_)[0]

# Scrivi il nome del file musicale (senza estensione) su un file di testo
with open("music_downloader.txt", "w") as file:
    file.write(song_name + "\n")

print("Music downloaded successfully!")