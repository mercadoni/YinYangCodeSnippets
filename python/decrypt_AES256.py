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
key = "8y/B?E(H+ShVmMbPeYq3t6w9z$C&F)J@"

#Initial vector, you can find it in the payload of the webhook inside "identification" object
iv = "+nHd/pLHSx5eYdDCKFnSUw=="

# Encrypted data that you can find in the payload of the webhook inside "identification" object
encryptedData = "vID0K2x2M+kbZOCgbvaqzNJzCY2LuawjFRcCDmyiXgs="

# Here we call the function decrypt defined above
print('Decrypted  Data: ', decrypt(encryptedData, key, iv))

