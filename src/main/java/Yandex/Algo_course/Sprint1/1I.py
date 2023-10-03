a = input()


def pow_of_four(a):
    if a == "1" or a == "4" or a == "16" or a == "64" or a == "256" or a == "1024" or a == "4096":
        return "True"
    else:
        return "False"


# это тоже, своего рода, алгоритм!

print(pow_of_four(a))
