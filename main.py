import hashlib
import hmac

#This is a reduced payload example used only for demonstration
payload = {
  "id": "90aa7525-3b40-4f9e-a7ff-347630d38aae",
  "created_at": "2022-01-01T0:00:00+0000",
  "type": "PICKING_FINISHED"
}

#This is an example of the key that Instaleap provided you
key = "e179017a-62b0-4996-8a38-e91aa9f1"


def signV1(payload, key):
  string_to_sign = "{}&{}&{}".format(payload['id'], payload['created_at'],payload['type'])

  byte_key = bytes(key, 'UTF-8')
  encoded_string_to_sign = string_to_sign.encode()
  signed_string = hmac.new(byte_key, encoded_string_to_sign, hashlib.sha256).hexdigest()

  return signed_string
# print the output
print(signV1(payload, key))
