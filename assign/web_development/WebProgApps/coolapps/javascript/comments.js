// GET comments
function getComments()
{
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'https://us-central1-my-cool-web-app-37271.cloudfunctions.net/getcomments');
// Track the state changes of the request.
    xhr.onreadystatechange= function () {
        let DONE = 4; // readyState 4 means the request is done.
        let OK = 200; // status 200 is a successful return.
        if (xhr.readyState=== DONE) {
            if (xhr.status === OK) {
                let sHTML = "";
                let data = JSON.parse(xhr.responseText);
                for(let i=0; i<data.length; i++)
                {
                    sHTML += "<p> Handle: " + data[i].handle+ "</p>";
                    sHTML += "<p> Comment: " + data[i].comment+ "</p>";
                    comments.innerHTML = sHTML;
                }
            } else {
                console.log('Error: ' + xhr.status); // An error occurred during the request.
            }}};
// Send the request to https://us-central1-my-cool-web-app-37271.cloudfunctions.net/getcomments
    xhr.send(null);
}

function editComments()
{
    let xhr = new XMLHttpRequest();
    xhr.open('PUT', 'https://us-central1-helping-in-galway.cloudfunctions.net/updatecomment');
// Track the state changes of the request.
    xhr.onreadystatechange= function () {
        let DONE = 4; // readyState 4 means the request is done.
        let OK = 200; // status 200 is a successful return.
        if (xhr.readyState=== DONE) {
            if (xhr.status === OK) {
                let sHTML = "";
                let data = JSON.parse(xhr.responseText);
                for(let i=0; i<data.length; i++)
                {
                    sHTML += "<p> Handle: " + data[i].handle+ "</p>";
                    sHTML += "<p id="+data[i].id +"> Comment: " + data[i].comment+ "</p>";
                    sHTML += "<button onclick=deleteComment(" + "'" + data[i].id + "'" + ")>Delete
                    Comment</button>";
                    sHTML += "<button id='edit_" + data[i].id + "' onclick=editComment(" + "'" +
                        data[i].id + "','" + encodeURIComponent(data[i].comment) + "'" + ")>Edit Comment</button>";
                    comments.innerHTML = sHTML;
                }
            } else {
                console.log('Error: ' + xhr.status); // An error occurred during the request.
            }}};
// Send the request to https://us-central1-my-cool-web-app-37271.cloudfunctions.net/getcomments
    xhr.send(null);
}