from mylist import List

class Dict(List):
    def __init__(self):
        self.__keys = List()
        self.__values = List()

    def update(self,**kwargs):
        pass

    def get(self,key):
        idx = self.__keys.search(key)
        if idx == -1:
            return None
        else:
            return self.__values[idx]

    def __getitem__(self,key):
        idx = self.__keys.search(key)
        if idx == -1:
            raise KeyError("Key Error")
        else:
            return self.__values[idx]
            
    def __setitem__(self,key,value):
        idx = self.__keys.search(key)
        if idx == -1:
            self.__keys.append(key)
            self.__values.append(value)
        else:
            self.__keys[idx] = key
            self.__values[idx] = value

    def keys(self):
        return self.__keys

    def values(self):
        return self.__values

    def items(self):
        return myzip(self.__keys, self.__values)

    def __str__(self):
        if self.__keys.count <1:
            return "{}"

        print("{",end="")
        for i in range(self.__keys.count-1):
            print("{}: {}, ".format(self.__keys[i],self.__values[i]),end="")
        print("{}: {}".format(self.__keys[i+1],self.__values[i+1]),end="")
        return "}"

    def __repr__(self):
        return self.__str__()

def myzip(a,b):
    result = List()
    min_val = a.count
    if min_val > b.count:
        for i in range(b.count):
            result.append((a[i],b[i]))
    else:
        for i in range(min_val):
            result.append((a[i],b[i]))
    return result
