const crypto = require('crypto');


const decrypt = (key, crypticResponse)=> {
  const iv = Buffer.from(crypticResponse.iv, 'base64')
  const encryptedText = Buffer.from(crypticResponse.encryptedData, 'base64')
  const decipher = crypto.createDecipheriv("aes-256-cbc", Buffer.from(key), iv)
  let decrypted = decipher.update(encryptedText)
  decrypted = Buffer.concat([decrypted, decipher.final()])
  return JSON.parse(decrypted.toString())
}

// Key given to you by Instaleap
const key = "7ZEYKlLdCA5fVySubsetmjdknROS7wFB"

// Initial vector, you can find it in the payload of the webhook inside "identification" object
const iv = "6maEJ/ULdKBO4OIKz3/NWA=="

// Encrypted data that you can find in the payload of the webhook inside "identification" object
const encryptedData = "CPEqmqjdpqx86dVRtU8mENJ3mwh5P3nYYa7WWyU5NTvqWuiFD2t74jvBR7YpIDHf"

// Here we call the function decrypt defined above
console.log('Decrypted  Data: ', decrypt(key, {encryptedData,iv}))
