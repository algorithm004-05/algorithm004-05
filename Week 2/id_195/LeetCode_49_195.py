class Solution:
    def groupAnagrams(self, strs):
        sorted_strs = {}
        for i in range(len(strs)):
            string = str(sorted(strs[i]))
            if string not in sorted_strs:
                sorted_strs[string] = [i]
            else:
                sorted_strs[string].append(i)
        words_list = []
        for i in sorted_strs:
            same = []
            for j in sorted_strs[i]:
                same.append(strs[j])
            words_list.append(same)

        return words_list