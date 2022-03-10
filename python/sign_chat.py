import hashlib
import hmac

#This is a reduced payload example used only for demonstration
payload = {
    "timestamp": "2022-03-08T00:18:39.115Z",
    "client_id": "YINYANG",
    "sender": "SUP",
    "job_id": "f0b9930f-8aca-4ace-9d9c-d5684343b9a7",
    }

#This is an example of the key that Instaleap provided you
key = "sdfsdfsdf234234234sdfsdfsdfsdfdsf"


def sign(payload, key):
  string_to_sign = "{}&{}&{}&{}".format(payload['timestamp'], payload['client_id'],payload['sender'],payload['job_id'])

  byte_key = bytes(key, 'UTF-8')
  encoded_string_to_sign = string_to_sign.encode()
  signed_string = hmac.new(byte_key, encoded_string_to_sign, hashlib.sha256).hexdigest()

  return signed_string

# Print the signed string
print("instaleap-signature-v3: t="+payload['timestamp']+",v3="+sign(payload, key))
