import numpy as np
import matplotlib.pyplot as plt

x_train = np.array([1.0,2.0,3.0])
y_train = np.array([100.0,320.0,450.0])

temp_alpha = 0.0001
ini_w = 100
ini_b = 200

def compute_cost(x,y,w,b):

    m = x.shape[0]
    f_wb = w*x+b
    j_wb = np.sum((f_wb - y)**2)
    cost = j_wb / (2*m)
    return cost

def compute_gradient(x,y,w,b):

    m = x.shape[0]
    dj_dw = 0
    dj_db = 0

    for i in range(m):
        f_wb = w*x[i]+b
        dj_dw_i = (f_wb - y[i]) * x[i]
        dj_db_i = f_wb - y[i]
        dj_dw += dj_dw_i
        dj_db += dj_db_i
    dj_db = dj_db / m
    dj_dw = dj_dw / m
    return dj_dw, dj_db

def gradient_descent(x,y,w_in,b_in,alpha,iteration):

    w = w_in
    b = b_in
    j_history = []
    for i in range(iteration):
        dj_dw, dj_db = compute_gradient(x,y,w,b)
        w = w - alpha*dj_dw
        b = b - alpha*dj_db
        j_history.append(compute_cost(x,y,w,b))

    return w,b,j_history

def compute_model_output(x,w,b):
    m = x.shape[0]
    f_wb = np.zeros(m)
    for i in range(m):
        f_wb[i] = w*x[i]+b
    return f_wb

w_result,b_result,history = gradient_descent(x_train,y_train,ini_w,ini_b,temp_alpha,500000)
temp = compute_model_output(x_train,w_result,b_result)
plt.plot(x_train,temp,label='Resu')
plt.scatter(x_train,y_train,label='Original')
print(history)
plt.show()