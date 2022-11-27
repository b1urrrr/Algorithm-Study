x_vertex = []
y_vertex = []
for i in range(3):
    n, m = map(int, input().split())
    x_vertex.append(n)
    y_vertex.append(m)

x_rec = max(x_vertex)-min(x_vertex)
y_rec = max(y_vertex)-min(y_vertex)

print(min(x_vertex) + x_rec, min(y_vertex) + y_rec)