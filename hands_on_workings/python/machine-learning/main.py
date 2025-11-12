import matplotlib.pyplot as plt
import numpy as np

x_train = np.array([1.0,2.0])
y_train = np.array([300.0,500.0])

#
# plt.scatter(x_train,y_train,marker='o',color='blue')
# plt.title("Scatter Plot")
# plt.xlabel("x")
# plt.ylabel("y")
# plt.show()

w = 200
b = 100

def compute_model_output(x,w,b):

    m = x.shape[0]
    f_wb = np.zeros(m)
    for i in range(m):
        f_wb[i] = w * x[i] + b
    return f_wb

tmp_f_wb = compute_model_output(x_train,w,b)

plt.plot(x_train,tmp_f_wb)
plt.scatter(x_train,y_train)
plt.show()


