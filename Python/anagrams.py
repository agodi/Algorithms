def findAnagrams(words):
  aux = {}
  x = [sorted(n) for n in words]
  for i in x:
    key = "".join(i)
    if key in aux:
      continue
    else:
      aux[key] = [k for k, j in enumerate(x) if j == i]
  for n in aux.values():
    anagrams = []
    for i in n:
        anagrams.append(words[i])
    print(anagrams)
      

findAnagrams(["banana", "aaannb", "race", "yellow", "nabana", "acre", "dog", "reca", "god", "odg"])
