import hashlib
import hmac

#This is a reduced payload example used only for demonstration
payload = {
    "id": "e33cc801-9f47-4077-9892-fd4a6db5d51f",
    "client_id": "6c5801a7-23ce-40be-8f60-aefdd2c48fef",
    "created_at": "2022-01-01T0:00:00+0000",
    "job_id": "cb7f44ba-71ac-428e-b752-dfa757f36dfb",
    "sender": "SH"
    }

#This is an example of the key that Instaleap provided you
key = "e179017a-62b0-4996-8a38-e91aa9f1"


def sign(payload, key):
  string_to_sign = "{}&{}&{}&{}&{}".format(payload['id'], payload['client_id'] payload['created_at'],payload['job_id'],payload['sender'])

  byte_key = bytes(key, 'UTF-8')
  encoded_string_to_sign = string_to_sign.encode()
  signed_string = hmac.new(byte_key, encoded_string_to_sign, hashlib.sha256).hexdigest()

  return signed_string

# Print the signed string
print(sign(payload, key))
