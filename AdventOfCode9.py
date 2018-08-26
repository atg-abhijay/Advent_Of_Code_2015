import copy
from pprint import pprint
import sys

num_cities = 8

def main():
    pair_and_distance = parse(sys.argv[1])
    pprint(pair_and_distance)
    pd_copy = copy.deepcopy(pair_and_distance)
    path = form_path(pair_and_distance)
    print(path)
    distance = findDistance(path, pd_copy)
    print("Distance: ", distance)


def form_path(pair_and_distance):
    path = [None] * num_cities
    counter = 0
    contains_something = True
    while contains_something:
        furthest_distance = 0
        furthest_pair = ()
        for pair, distance in pair_and_distance.items():
            if distance > furthest_distance:
                furthest_distance = distance
                furthest_pair = pair

        path[counter] = furthest_pair[0]
        path[-1-counter] = furthest_pair[1]
        print(path)
        counter+=1

        # del pair_and_distance[furthest_pair]
        makeDeletions(pair_and_distance, furthest_pair)
        if not pair_and_distance:
            contains_something = False

    return path

def findDistance(path, pair_and_distance):
    total_distance = 0
    path_counter = 0
    while path_counter < num_cities - 1:
        firstCity = path[path_counter]
        secondCity = path[path_counter+1]
        pair = (firstCity, secondCity)
        if pair not in pair_and_distance:
            pair = (secondCity, firstCity)
        total_distance += pair_and_distance[pair]
        path_counter+=1

    return total_distance


def makeDeletions(pair_and_distance, furthest_pair):
    del pair_and_distance[furthest_pair]
    start = furthest_pair[0]
    end = furthest_pair[1]
    for pair in pair_and_distance.keys():
        if start in pair or end in pair:
            del pair_and_distance[pair]

def parse(file_address):
    f = open(file_address)
    pair_and_distance = {}
    for line in f.readlines():
        line = line.replace("\n", "")
        # print line
        line_parts = line.split(" = ")
        distance = line_parts[1]
        # print line_parts
        pair_cities = tuple (line_parts[0].split(" to "))
        pair_and_distance[pair_cities] = int (distance)

    return pair_and_distance


def test():
    d = {"a": 1, "b":2}
    # element = d["c"]
    # print(element)
    l = [1,2,3,4,5,6,7,8,9]
    iterator = iter(l)
    for x in iterator:
        print(x, next(iterator))

main()