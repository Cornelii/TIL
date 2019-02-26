# argparse

example
```python
import argparse


parser = argparse.ArgumentParser()

# positional arguments

parser.add_argument("echo")
parser.add_argument('team', help="nothing", type = int)


# optional arguments
parser.add_argument('--verbosity', help="output verbosity")

args = parser.parse_args()
if args.verbosity:
    print("yes! {}".format(args.verbosity))

print(args.echo)
print(args.echo)
print(args.echo)
print(args.team**2)
```

> python test.py -h
This manifest help of given arguments

## I. Positional Arguments
1. make parser by `argparse.ArgumentParser()`
2. add argument by `{parser_object}.add_argument({argument_name})`

parameters of `.add_argument`
* {argument name}
* help : description by `-h`
* type : what type do you want to get


## II. Optional Arguments
