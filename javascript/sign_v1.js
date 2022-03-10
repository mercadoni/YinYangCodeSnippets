
const crypto = require('crypto');

//This is a reduced payload example used only for demonstration purposes
const payload = {
    "id": "90aa7525-3b40-4f9e-a7ff-347630d38aae",
    "created_at": "2022-01-01T0:00:00+0000",
    "type": "PICKING_FINISHED"
  }
//This is an example of the key that Instaleap provided you
const key = "e179017a-62b0-4996-8a38-e91aa9f1";

const signV1 = (payload, key)=>{
    const stringToSign = `${payload.id}&${payload.created_at}&${payload.type}`
    const hmac = crypto.createHmac('sha256', key);
    hmac.update(stringToSign);
    return hmac.digest('hex');
}

// Print the signed string
console.log('instaleap-signature: '+signV1(payload,key))
