const functions = require('firebase-functions');
const admin = require('firebase-admin');
const cors = require('cors')({origin: true});
admin.initializeApp();

exports.updatecomment = functions.https.onRequest((request, response) => {
// 1. CORS
    cors(request, response, () => {
// Record timestamp
        const currentTime = admin.firestore.Timestamp.now();
        request.body.timestamp = currentTime;
// 2. Connect to Firestore
        return admin.firestore().collection('comments').doc(request.query.id).update({comment:request.body.comment,
            timestamp:request.body.timestamp}).then(() => {
// 3. Document updated successfully
            response.send("Document successfully updated!");
        });
    });
});