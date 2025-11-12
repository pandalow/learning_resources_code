is_continue = False

morse_code = {
    'a':'. -',
    'b':'- . . .',
    'c':'- . - .',
    'd':'.',
    'e':'. . - .',
    'f':''
}

def interpret(message):
    
    translation = [morse_code[char] for char in message]
    
    return ' '.join(translation)
    
        
    
while True:
    input_morse = input("Please enter the message")
    
    if input_morse == '-1':
        break
    
    print(interpret(input_morse))
    

    

