import json

from helper import draw_coloured_map, generate_graph_map

colors = ["red", "blue", "green", "yellow", "orange", "purple", "cyan", "magenta", "lime"]


def greedy(graph):

    colors_dict = {}

    for node in graph:
        used_colors = {colors_dict[neigh]
                        for neigh in graph[node]
                            if neigh in colors_dict
                        }

        for color in colors:
            if color not in used_colors:
                colors_dict[node] = color
                break

    return colors_dict


if __name__ == "__main__":
    n = 4
    map = generate_graph_map(n)
    solution = greedy(map["graph"])

    if solution:
        print("Solution found:", solution)
        draw_coloured_map(map, solution)
        with open('solution.json', 'w') as f:
            json.dump(solution, f)
            f.close()
    else:
        print("Solution not found.")






