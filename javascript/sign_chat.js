const crypto = require('crypto');

//This is a reduced payload example used only for demonstration purposes
const payload = {
    "id": "e33cc801-9f47-4077-9892-fd4a6db5d51f",
    "client_id": "6c5801a7-23ce-40be-8f60-aefdd2c48fef",
    "created_at": "2022-01-01T0:00:00+0000",
    "job_id": "cb7f44ba-71ac-428e-b752-dfa757f36dfb",
    "sender": "SH"
  }
//This is an example of the key that Instaleap provided you
const key = "e179017a-62b0-4996-8a38-e91aa9f1";

const sign = (payload, key)=>{
    const stringToSign = `${payload.id}&${payload.client_id}&${payload.created_at}&${payload.job_id}&${payload.sender}`
    const hmac = crypto.createHmac('sha256', key);
    hmac.update(stringToSign);
    return hmac.digest('hex');
}

// Print the signed string
console.log(sign(payload,key))
