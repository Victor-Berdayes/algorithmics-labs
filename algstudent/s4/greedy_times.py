import time
from graph_colouring import greedy
from helper import generate_graph_map

def measure_greedy_time(n):
    graph_data = generate_graph_map(n)
    graph = graph_data["graph"]

    start_time = time.time()
    solution = greedy(graph)
    elapsed_time = time.time() - start_time

    return elapsed_time * 1000  # milisegundos

if __name__ == "__main__":
    for n in range (8, 65536, 8):
        elapsed_ms = measure_greedy_time(n)
        print(f"Greedy({n} nodes) took {elapsed_ms:.2f} ms")

