from __future__ import division

def answer(minions):
    ''' Return the fastest expected minion interrogation order given a list
        of [time, prob_numerator, prob_denominator] minion info.
    '''
    num_minons = len(minions)
    assert 2 <= len(minions) <= 50

    sortkey = [t/(n/d) for t, n, d in minions]

    return sorted(range(num_minons), key = sortkey.__getitem__)

data = [[390, 185, 624], [686, 351, 947], [276, 1023, 1024], [199, 148, 250],[390, 185, 624], [686, 351, 947], [276, 1023, 1024], [199, 148, 250]]
print answer(data)

[6, 2, 7, 3, 0, 4, 1, 5]