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
const key = "8y/B?E(H+ShVmMbPeYq3t6w9z$C&F)J@"

// Initial vector, you can find it in the payload of the webhook inside "identification" object
const iv = "+nHd/pLHSx5eYdDCKFnSUw=="

// Encrypted data that you can find in the payload of the webhook inside "identification" object
const encryptedData = "vID0K2x2M+kbZOCgbvaqzNJzCY2LuawjFRcCDmyiXgs="

// Here we call the function decrypt defined above
console.log('Decrypted  Data: ', decrypt(encryptedData, key, iv))
