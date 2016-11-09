#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys

if __name__ == '__main__':
    if len(sys.argv) != 2:
        print "Usage: format.py <string>"
        exit(0)

    n, s = sys.argv
    parts = [i.capitalize() for i in s.split(' ')]
    fs = 'L' + ('%03d' % int(parts[0].replace('.', ''))) + '_' + ''.join(parts[1:])
    print fs.replace('Iii', 'III').replace('Ii', 'II')
