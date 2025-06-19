window.onload = () => {
    function bindCaptchaBtnClick() {
        $('#validation-code').click(function(event) {
            let $this = $(this);
            let email = $("input[name='email']").val();

            if (!email) {
                alert('Please enter your email.');
                return;
            }

            $.ajax('/user/send_email?email=' + email,{
                method: 'GET',
                success: function(response) {
                    console.log(response);
                },
                error: function(error) {
                    console.log(error);
                }
            });

            $this.off('click');
            let countDown = 60;
            let timer = setInterval(() => {
                if (countDown <= 0) {
                    $this.text('Acquire Code');
                    clearInterval(timer);
                    bindCaptchaBtnClick();
                } else {
                    $this.text(`Acquire Code (${countDown--}s)`);
                }
            }, 1000);
        });
    }

    bindCaptchaBtnClick();
};
