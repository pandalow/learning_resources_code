    function updateCharacterCount() {
    let comment = document.getElementById('comment');
    let charCount = document.getElementById('charCount');
    let remaining = 280 - comment.value.length;
    charCount.textContent = remaining;
}

    function getComments()
    {
        let xhr = new XMLHttpRequest();
        xhr.open('GET', 'https://us-central1-assignment5-zhuang.cloudfunctions.net/getcomments');
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
                        sHTML += "<p> Comment: " + data[i].comments+ "</p>";
                        comments.innerHTML = sHTML;
                    }
                } else {
                    console.log('Error: ' + xhr.status); // An error occurred during the request.
                }}};
// Send the request to https://us-central1-my-cool-web-app-37271.cloudfunctions.net/getcomments
        xhr.send(null);
    }

    function postComment(){
        let xhr = new XMLHttpRequest();
        xhr.open('POST', 'https://us-central1-assignment5-zhuang.cloudfunctions.net/postcomments');
        xhr.setRequestHeader("Content-type", "application/json");
// Track the state changes of the request.
        xhr.onreadystatechange= function () {
            let DONE = 4; // readyState 4 means the request is done.
            let OK = 200; // status 200 is a successful return.
            if (xhr.readyState=== DONE) {
                if (xhr.status === OK) {
                    getComments(); // 'Call get comments to retrieve the latest'
                } else {
                    console.log('Error: ' + xhr.status); // An error occurred during the request.
                }
            }
        };

        xhr.send(JSON.stringify(
            {"comments": document.getElementById('comment').value}));
        comment.innerHTML = "";
    }

    window.onload = function() {
        getComments();
    };