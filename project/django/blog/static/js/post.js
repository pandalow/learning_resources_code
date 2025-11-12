window.onload = function(){
    const { createEditor, createToolbar } = window.wangEditor

const editorConfig = {
    placeholder: 'Type here...',
    onChange(editor) {
      const html = editor.getHtml()
      console.log('editor content', html)
      // You can sync HTML to <textarea>
    }
}

const editor = createEditor({
    selector: '#editor-container',
    html: '<p><br></p>',
    config: editorConfig,
    mode: 'default', // or 'simple'
})

const toolbarConfig = {}

const toolbar = createToolbar({
    editor,
    selector: '#toolbar-container',
    config: toolbarConfig,
    mode: 'default', // or 'simple'
})

$('#post-btn').click(function(event){
    event.preventDefault();

    let title = $('input[name="title"]').val();
    let category = $('#category-select').val();
    console.log(category)
    let content = editor.getHtml(); 
    console.log(content)
    let csrfmiddlewaretoken = $('input[name="csrfmiddlewaretoken"]').val();

    $.ajax('/post', {
        method: 'POST',
        data: {
            title,category,content,csrfmiddlewaretoken
        },
        success: function(response) {
            console.log(response);
        },
        error: function(response) {
            console.log(response);
        }
    });
});
}
