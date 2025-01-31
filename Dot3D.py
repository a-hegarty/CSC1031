#!/bin/env/usr python3

#author: Aoibhe hegarty
#date: 16/01/2025
#input: coordinates x, y, z, and label "x1"

import math

class Dot3D:
    def __init__(self, x, y, z, label=None):
        self.x = x
        self.y = y
        self.z = z
        self.label = label

# below function calculates distrance betweeen two points on a 3d plane
# using formula sqrt((x2 - x1)^2 + (y2 - y1)^2 + (z2 - z1)^2
#big ol complicated thing but we ball
    def distance_to(self, other):
        X_dist = (other.x - self.x) ** 2
        Y_dist = (other.y - self.y) ** 2
        Z_dist = (other.z - self.z) ** 2
        distance = math.sqrt(X_dist + Y_dist + Z_dist)
        return distance

    def add_vector(self, other):
        vector_X = self.x + other.x
        vector_Y = self.y + other.y
        vector_Z = self.z + other.z
        vector_Label = self.label + "+" + other.label
        return Dot3D(vector_X, vector_Y, vector_Z, vector_Label)

dot1 = Dot3D(3, 4, 5, "x1")
dot2 = Dot3D(6, 8, 10, "y1")

dist = dot1.distance_to(dot2)

# print(dist)

