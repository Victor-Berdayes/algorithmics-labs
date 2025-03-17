import json

from helper import draw_coloured_map, generate_graph_map

colors = ["red", "blue", "green", "yellow", "orange", "purple", "cyan", "magenta", "lime"]

my_dict = {}


def greedy(mapa):
    color_ind = 0

    for node in mapa:
        my_dict.update({node: colors[color_ind]})
        color_neighbours(node, mapa[node])



def color_neighbours(node, connections):

    for neighbour in connections:
        color_ind = 0;
        while my_dict[node] == my_dict[neighbour]:
            my_dict[neighbour] = colors[color_ind]

            if color_ind == len(colors)-1:
                color_ind = 0
            else:
                color_ind+=1


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






