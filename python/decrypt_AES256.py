import base64
import json
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad,unpad

#In order to run this script you'll need to isntall pycryptodome library

def decrypt(enc,key,iv):
  enc = base64.b64decode(enc)
  iv = base64.b64decode(iv)
  cipher = AES.new(key.encode('utf-8'), AES.MODE_CBC, iv)
  result = unpad(cipher.decrypt(enc),16).decode("utf-8")
  return result


# Key given to you by Instaleap
key = "7ZEYKlLdCA5fVySubsetmjdknROS7wFB"

#Initial vector, you can find it in the payload of the webhook inside "identification" object
iv = "6maEJ/ULdKBO4OIKz3/NWA=="

# Encrypted data that you can find in the payload of the webhook inside "identification" object
encryptedData = "CPEqmqjdpqx86dVRtU8mENJ3mwh5P3nYYa7WWyU5NTvqWuiFD2t74jvBR7YpIDHf"

# Here we call the function decrypt defined above
print('Decrypted  Data: ', decrypt(encryptedData, key, iv))

