const {onRequest} = require("firebase-functions/v2/https");
const logger = require("firebase-functions/logger");
const admin = require('firebase-admin');
 admin.initializeApp();


exports.postcomments = onRequest((request, response) => logger.info("Accepting comments from clients", {structuredData: true});
    const currentTime = admin.firestore.Timestamp.now();
    request.body.timestamp = currentTime;
    cors(request, response, () => {
    admin.firestore().collection("comments").add(request.body).then(() => {
        response.send("Saved in the database");
        });
    });
});

exports.getcomments= onRequest((request, response) =>
{
    cors(request, response, () => {
// 1. Connect to our Firestore database
    let myData= []
    return admin.firestore().collection('comments').orderBy('timestamp').get().then((snapshot) => {
        if (snapshot.empty) {
            console.log('No matching documents.');
            response.send('No data in database');
            return;
        }
        snapshot.forEach(doc => {
            myData.push(doc.data());
        });
// 2. Send data back to client
        response.send(myData);
        }
    })
});

