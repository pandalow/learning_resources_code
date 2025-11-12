
let array = [];


function Comment(){
    let inputEmail = document.getElementById('email').value;
    let inputValue = document.getElementById('comment').value;
    let Post_Comment = {email:inputEmail,comment: inputValue};
    array.push(Post_Comment);
    display()
    document.getElementById('comment').value = '';
}
function display(){
    let displaycomment = document.getElementById('Displaycomment');
    displaycomment.innerHTML = "";

    for(let i = 0;i < array.length;i++){
        if(array[i].email.includes('hacker')){
            continue;
        }else{
            displaycomment.innerHTML += '<br>' + 'E-mail: ' + array[i].email +'<br>'+ 'Comment: ' + array[i].comment;
        }
    }
}