const crypto = require('crypto');

//This is a reduced payload example used only for demonstration purposes
const payload = {
    "timestamp": "2022-03-08T00:18:39.115Z",
    "client_id": "YINYANG",
    "sender": "SUP",
    "job_id": "f0b9930f-8aca-4ace-9d9c-d5684343b9a7",
  }
//This is an example of the key that Instaleap provided you
const key = "sdfsdfsdf234234234sdfsdfsdfsdfdsf";

const sign = (payload, key)=>{
    const stringToSign = `${payload.timestamp}&${payload.client_id}&${payload.sender}&${payload.job_id}`
    const hmac = crypto.createHmac('sha256', key);
    hmac.update(stringToSign);
    return hmac.digest('hex');
}

// Print the signed string
console.log(`instaleap-signature-v3: t=${payload.timestamp},v3=${sign(payload,key)}`)
