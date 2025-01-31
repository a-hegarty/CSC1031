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

    #function adds points together to make a new vector
    def add_vector(self, other):
        vector_X = self.x + other.x
        vector_Y = self.y + other.y
        vector_Z = self.z + other.z
        vector_Label = self.label + "+" + other.label
        return Dot3D(vector_X, vector_Y, vector_Z, vector_Label)
    
class Triangle3D:
    def __init__(self, dot1, dot2, dot3):
        self.dot1 = dot1
        self.dot2 = dot2
        self.dot3 = dot3

    #function returns perimeter of triangle
    # which is the sum of the length/distance between all three sides
    def calculate_perimeter(self):
        side1 = self.dot1.distance_to(dot2)
        side2 = self.dot2.distance_to(dot3)
        side3 = self.dot3.distance_to(dot1)
        perimeter = side1 + side2 + side3
        return perimeter
    
    #function returns area of triange as calc'd using herons formula
    #which requires a semi perimeter and all three edges
    def calculate_area(self):
        s = (self.calculate_perimeter()) / 2
        #semi perimeter isjust the perimeter / 2
        side1 = self.dot1.distance_to(dot2)
        side2 = self.dot2.distance_to(dot3)
        side3 = self.dot3.distance_to(dot1)
        area = math.sqrt(s * (s - side1) * (s - side2) * (s - side3))
        return area

dot1 = Dot3D(3, 0, 0, "x1")
dot2 = Dot3D(0, 4, 0, "y1")
dot3 = Dot3D(0, 0, 0, "z1")

tri1 = Triangle3D(dot1, dot2, dot3)

perim = tri1.calculate_perimeter()
area = tri1.calculate_area()


