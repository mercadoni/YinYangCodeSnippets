const crypto = require('crypto');


const decrypt = (key, crypticResponse)=> {
  const iv = Buffer.from(crypticResponse.iv, 'base64')
  const encryptedText = Buffer.from(crypticResponse.encryptedData, 'base64')
  const decipher = crypto.createDecipheriv("aes-256-cbc", Buffer.from(key), iv)
  let decrypted = decipher.update(encryptedText)
  decrypted = Buffer.concat([decrypted, decipher.final()])
  return JSON.parse(decrypted.toString())
}

/*
Identification node example, this should be extracted from webhook payload.
In this example, the encrypted data is the following json object:
{ type: 'CC', number: 41373878 }
*/

const identification = {
        "iv": "GjeFhTTgIu/Qp90miQ3UAQ==",
        "encryptedData": "G0030G3Knuegoqmrt7KwhcZoDlcxyUm2BHHLymJh6RE="
      }
console.log(decrypt(")J@NcRfUjXn2r5u8x/A%D*G-KaPdSgVk",identification))