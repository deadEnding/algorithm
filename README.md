# algorithm
On the way.

### Tips
+ 首先确定数据结构
+ 迭代着思考问题
+ 边界测试
+ 规律性题目按周期处理
+ **加减乘除**溢出，绝对值溢出（MIN_VALUE -> MAX_VALUE+1）,MIN_VALUE乘以-1溢出
+ 链表: 首尾节点特殊处理、常用方法两个指针分别同时遍历（速度不同、起始时间不同）、删除某个节点时增加dummy，避免增删首节点的特殊情况；dummy使用时，不一定需要dummy.next=head连接原链表，也可筛选节点加到dummy链表的尾部构成新链表
+ 回溯法: 从某集合中选取部分或全部元素（元素可被使用1次、无数次、固定次）组合以满足一定要求。回溯方法的参数: ix（可选, 当前步数、层次或候选元素界限）, path记录树路径
+ 分治法：分治法解决问题是考虑是否有子问题重复计算的问题，如果有，使用动态规划
+ 二叉树：首先考虑方法参数中的root为空如何处理，递归解决问题
+ Trie树的节点可以根据需求定制保存的信息: isWord，word，count等
+ 给定矩阵，进行图的深度优先遍历时，可不使用visited二维数组记录已遍历的结果，可修改board[x][y]为不可能值，做为已遍历的标志，深度遍历完该点后再恢复
+ 动态规划状态确定：买卖状态、
+ 栈: 越当前的部分越紧迫，不紧迫的先放入栈内暂存，处理完当前紧迫部分再出栈继续之前的处理。栈的暂存、备选特性，栈内元素一定呈递增或递减顺序
+ 滑动窗口
+ 二叉树问题可思考递归或迭代方法
+ 堆解决了数组二分插入维持有序性时插入元素效率低的问题
+ 图的存储：邻接表: 节点编号[0, n-1], HashSet<Integer>[] adj；编号不定HashMap<Integer, HashSet<Integer>> adj；邻接矩阵
+ 数字前导零问题


### 技巧
+ 获取比Integer.MIN_VALUE小1的值: `Integer.MIN_VALUE - 1L`，必须要有`L`，否则溢出
+ 求两个非负数的平均数: `first + (second - first) / 2`。（`(first + second) / 2`会溢出）
+ 二叉树中序遍历时，当中间节点的访问（或构造）等需要用到左子树最后一个节点时，可用一个全局变量记录已遍历节点的最后一个节点（Leetcode 99,109）
+ 求二叉树中某段连续节点（上下）的值的总和是可用尾节点到根节点的距离减去头结点到根节点的距离（先序遍历）
+ 先序、中序、后序的区别在于对当前节点的访问（root.val）与递归调用左右子树方法（root.left, root.right）的相对位置
+ 二叉树深度优先遍历过程，可以在到达叶子节点（或Null）时修改全局变量的值；也可以将值按原路访问，一直汇总到根节点，两种方式有啥区别?
+ 二分查找：基于索引的二分、基于值的二分（打气球、1-n内只有一个数重复287）
+ 逆向思维：n元素数组，每次对n-1个数加1，相对效果等价于对1个数减1(453)，气球爆破问题
+ 数组双指针、链表双指
+ 持续判断、偶然中断的问题处理时，遇到持续段起点就while循环直至中断处（224或227、228）


### 题型
+ 只有一个数出现1次，其他n次：位统计法。特别地，n = 2时可以使用异或方法
+ 字符串分割，使得分割后的子串满足一定特点（131、139），可以采用使用动态规划从后向前迭代结果的方式（向前迭代有可能会存在内存超限，见140题两种解法）。另外，动规使用一维数组和二维数组选择标准：如果递归公式只需要一维即可建立，使用一维（139），否则使用二维（131）
+ 链表判断是否有环：快慢指针是否相遇
+ 链表求环的起点：快慢指针第一次相遇后，让新指针从头开始一步步走，同时慢指针也一步步走，当两指针相遇时即为环的起点
+ 链表找中间位置：快慢指针
+ 相交链表找起始交汇节点：求两链表长度，长链表对应指针先走长度差值步，然后两链表指针同时开始走，判断两指针是否相等即可
+ 单链表适合归并排序，双向链表适合快速排序，利用快慢指针找中间位置，分成两半
+ 地图类（左上角到右下角）使用动态规划时，有时候从左上角开始向右下角迭代时，每一步利用贪心选择时的局部最右未必是全局最优。这时可以从右下角开始向左上角迭代计算，可以达到全局最右（因为已经找准了目标）（174）
+ 值域在[1-n]中的数组：只有一个数重复多次（将nums[i]放到下标为nums[i]位置、环起点或二分287）
+ 回溯题目：47,90，回溯搜索的空间是一颗子集树(2^n)或排列树(n!)，保证结果集非重复的方式：排序 + 跳过重复值 或 使用Set保存已访问节点，避免重复访问
+ 字符串或序列在某处是否分隔的问题一般DP解决（140）
+ 求某种转换的最小值可能的算法：BFS、DP

### 常见错误
+ stack、queue的读取操作要判空
+ 逆序循环i--写成i++
+ 加减乘除溢出
+ 循环迭代中忘记修改ix或链表引用p，导致死循环
+ 输入边界测试

### 常用代码
+ Arrays.sort()
+ Arrays.binarySearch()
+ StringBuffer
+ TreeMap

### 后续疑问题型
+ 字符串非连续子串满足某约束条件时使用stack解决的题型

----

### LeetCode 有序版

+ [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description)
    题意：给定字符串，求不含重复字符的最长子串的长度。
    总结：（1）Map记录每个字符上次出现的下标。（2）滑动窗口
+ [4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/?tab=Description)
    题意：两个有序数组求中位数，要求O(log(m + n))
    总结：二分。有很多边界问题：num1溢出，num2溢出，终止条件
    错误：边界条件
+ [8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/#/description)
    题意：字符串s转化成整数。考虑尽可能多的异常情况
    总结：（1）s等于null返回0（2）s.trim()去掉收尾空白字符后若为""则返回0（3）首字符符号判断（4）遇到非数字后停止遍历（5）当num值超过Integer.MAX_VALUE时停止遍历（6）判断加符号后的num是否溢出
+ [10. Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/description/)
    题意：判断字符串与正则表达式是否匹配
    总结：DP。分情况讨论。
+ [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/#/description)
    题意：给定数组h，h[i]表示x = i处的竖线的高度，求由任意两条竖线和x轴围成的容器的最大容水量。
    总结：O(n)解法。双指针，每次向内收缩较矮的竖线对应的指针。
+ [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/#/description)
    题意：给定若干字符串ss，求所有字符串的最长公共前缀。
    总结：用ss[1:n-1]与ss[0]比较，依次比较每一位，出现不一致时即找到了最长公共前缀。
+ [15. 3Sum](https://leetcode.com/problems/3sum/#/description)
    题意：给定若干整数，求所有和为0的三元组，要求结果不重复。
    总结：O(n^2)。循环尾部do while去重，或循环首部if continue去重。
+ [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/#/description)
    题意：删除链表倒数第n个节点。
    总结：双指针。使用dummy，第一个指针先走n步，然后两指针一起走。
+ [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/#/description)
    题意：给定只包含()[]{}的字符串，判断括号是否合法
    总结：使用栈。注意出栈前判空。最后返回是只有栈空才返回true。
    错误：最后只有栈空时才返回true，不是直接返回true。
+ [23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/#/description)
    题意：合并K个有序链表
    总结：PriorityQueue<ListNode>存储每个列表当前的头结点，每次从堆中取出后，将其后继节点加入堆中。
+ [25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/#/description)
    题意：将给定链表的连续每k个节点翻转，节点数小于k时不翻转
    总结：先求出链表长度，然后每个k节点翻转一下，递归翻转后续节点。
+ [30. Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/#/description)
    题意：给定若干单词words和字符串s，求在s中所有恰好由words中单词拼接得到的子串的起始下标。
    总结：多维滑动窗口。使用count记录有效操作数。Map记录各单词个数。维护一个长度为words.length * words[0].length() 的滑动窗口。当count为0时，即窗口内子串恰好由words拼成。
+ [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/#/description)
    题意：给定左右括号构成的字符串，求最长合法子串的长度。
    总结：栈。关键问题是当左右括号匹配成功，栈顶出栈后如何得到当前最大长度。因此需要在栈内存储上次中断的位置。
+ [41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/#/description)
    题意：给定整数数组（任意数都可能有），求从1开始，缺少的第一个正整数。要求O(n),O(1)
    总结：调整数组，使得i位置的数为i + 1，即满足nums[i] == i + 1,最后遍历数组，第一个不满足该关系的位置ix即对应缺少的正整数ix + 1。注意负数、重复数、正整数对应下标超过数组长度的情况无需处理
    错误：上述边界条件问题。
+ [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
    题意：给定柱状图高度，求最大存水量
    总结：（1）从两边向中间的方向，每次迭代处理柱高较小的一侧，不断更新当前壁垒能维持水位的最小值，最小值减去当前处理的柱高即为当前柱对应的存水量（为负时即为0）。（2）使用两数组分别保存每个柱子左边、右边柱高的最大值，左边最大值和右边最大值中的最小值即为水位高度。叠加存水量即可。
+ [44. Wildcard Matching](https://leetcode.com/problems/wildcard-matching/)
    题意：给定字符串s和通配符字符串p，判断s是否匹配p。
    总结：（1）二维DP。（2）贪心。当匹配失败时且前面匹配遇到过星号，向前回溯重新匹配时只需要重新匹配最近星号后面的字符串即可。因此需要用starIx记录下最近星号的位置，用match记录s串应对从哪里重新匹配。
+ [45. Jump Game II](https://leetcode.com/problems/jump-game-ii/?tab=Description)
    题意：给定非负整数数组，元素值表示从该位置开始可以向后跳的最大步数，求从数组首元素跳到尾元素的最小步数。题目保证一定能从首元素跳到尾元素。
    总结：广度优先搜索。元素之间的跳转关系可以构成一张图。  （1）O(n)空间 BFS。使用队列广度优先遍历，使用变量visited表示已遍历过的最大下标（2）O(1)空间 BFS。实际上用两个变量即可确定广度优先遍历过程中每一层的下标。不需要队列。
    错误：动态规划超时。边界条件只有一个元素或没有元素时直接返回0。
+ [47. Permutations II](https://leetcode.com/problems/permutations-ii/)
    题意：包含重复数字的集合里的元素的各种非重复排列
    总结：（1）回溯，HashSet去重（2）HashMap统计元素出现次数，根据map回溯求解
    错误：排序后简单的略过重复值不能保证结果非重复。
+ [50. Pow(x, n)](https://leetcode.com/problems/powx-n/#/description)
    题意：求x(double)的n(int)次幂。
    总结：快速幂。当n < 0时，（1）求y = x ^ |n|，最后返回1.0/y；（2）求(1/x)^|n|。
    错误：|n|当n = Integer.MIN_VALUE时会溢出。需提前转成long。
+ [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/#/description)
    题意：给定若干区间，对区间合并
    总结：先判断原区间个数，若不超过1则不需要合并直接返回。否则先把第一个区间加入结果中，last记录结果中当前最后一个区间对象，遍历后续每个区间，判断与last的重叠情况选择追加到结果还是更新last.end。
+ [60. Permutation Sequence](https://leetcode.com/problems/permutation-sequence/?tab=Description)
    题意：求[1,2,3...n]组成的全排列中的第k个
    总结：实际上类似与进制转换，从高位开始，只是每一位的权值不是成比例的，k需要先减1（从0开始计数）
    错误：思路不清，细节变量弄混了
+ [72. Edit Distance](https://leetcode.com/problems/edit-distance/?tab=Description)
    题意：将word1转化成word2，支持替换、删除、增加字母，每次操作为一步，求最小编辑距离
    总结：动态规划，二维DP。f[i][j]表示word[0:i]到word[0:j]的最小编辑距离，求值等于增删改三种操作中的最小值，从左到右迭代求解。
    错误：字符串为空的边界问题，DP数组当i或j为0的初始值的初始化问题。
+ [80. Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/#/description)
    题意：有序数组中删除元素，使得每个元素最多不超过2个。
    总结：判断nums[i] != nums[ix - 2]时，则保留nums[i]，即nums[ix++] = nums[i]。
+ [81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/?tab=Description)
    题意：包含重复元素的循环有序数组中判断元素是否存在
    总结：关键在于二分时判断哪一边有序的，重复元素的存在导致当相等时不能判断哪边有序，只能l++(nums[l] == nums[m])或r--(nums[m] == nums[r])缩小一步。如果是nums[m] == nums[r],必须r--，这样删除nums[r]才不影响结果。
+ [84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)
    题意：连续的柱状图，求构成的最大的跨柱矩形的面积
    总结：（1）单调栈。关键问题在于遍历过程中对于较高矩形不知道其右边界的位置。利用栈的暂存特性，栈内保持从栈底到栈顶升序，为方便计算面积，栈内存储下标，栈内元素为找到了左边界而未找到右边界的矩形，当出现小于栈顶元素的值时，说明遇到了右边界，此时连续出栈并根据i和新栈顶元素的下标计算面积，更新最大面积，连续出栈直至栈顶元素的值不大于当前值，然后将当前值的下标入栈。（2）判断范围内的柱子是否有序，有序的话循环求以各柱为起始柱的面积，取最大值返回；无序的话，以最矮柱为界限，分成两半，递归求左半和右半，然后返回左半最大值、右半最大值、最矮柱乘宽度三者中的最大值
    错误：不会
+ [85. Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/)
    题意：0、1矩阵，求求由1组成的矩形的最大面积
    总结：分层逐级求解。把前i层看成柱状图（1）O(n^2)。用84题中的方法求解。最后取各层的最大值中的最大值返回。与最大子矩阵（O(n^3)）的区别在于每个元素非1即0，高度与列和成正比，从高度上间接保证了一定是矩形。（2）(right(i,j) - left(i, j)) * height(i, j)。实际上right、left、height可以用一维数组，并且三个数组在按行处理是都是可迭代用O(1)的时间得到的，而不需要每行都重新计算。
    错误：不会
+ [86. Partition List](https://leetcode.com/problems/partition-list/#/description)
    题意：给定链表和x，调整链表结构使得小于x的节点均出现在大于等于x的节点前。
    总结：使用两个dummy节点p,q分别存储小于和大于等于x的节点。注意最后不仅要把两个子链表拼接起来，还要把q.next置为null。
    错误：q.next没有置为null。
+ [89. Gray Code](https://leetcode.com/problems/gray-code/?tab=Description)
    题意：给定n，生成n位二进制数的格雷码
    总结：（1）规律题，根据n-1位的格雷码构造n位格雷码，逆序加高位1即可（2）第i个格雷码为 i ^ (i - 1)
    错误：当n=0时返回[0]而不是空数组
+ [91. Decode Ways](https://leetcode.com/problems/decode-ways/?tab=Description)
    题意：给定数字串，以1-A,2-B,...,26-Z的对应方式解码，求一共多少种解码方式
    总结：动态规划。类似于上台阶
    错误：边界条件，空串和0开头的串
+ [91. Decode Ways](https://leetcode.com/problems/decode-ways/)
    题意：将整数序列按照数字和字母的对应关系进行翻译，求共有多少种翻译结果
    总结：每次迭代有多种选择的情况可能会有重复子问题，递归求解有大量重复计算。与爬楼梯问题相同。
    错误：边界问题，迭代起始值问题
+ [92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)
    题意：反转链表中第m到第n个节点
    总结：头插法逆转链表时，curr始终是待逆转段的尾节点（不用调用curr = ***.next迭代），且curr.next = prev.next而不是curr.next = curr
    错误：头插法重建连接关系时出错
+ [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
    题意：中序遍历二叉树（递归、非递归）
    总结：出栈的时候访问元素的值，栈中存储的是在遍历左子树时需要暂留的中间节
    错误：循环条件
+ [95. Unique Binary Search Trees II](https://leetcode.com/problems/unique-binary-search-trees-ii/)
    题意：构建1..n组成的全部的二叉搜索树
    总结：递归求解，笛卡尔乘积种情况
    错误：边界条件，n == 0时返回空，不是返回null
+ [96. Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/#/description)
    题意：由1-n的整数能构造出多少个不同的BST。
    总结：DP。实际上构造出的BST的个数只与整数个数有关。
    错误：边界条件，n == 0时返回0
+ [97. Interleaving String](https://leetcode.com/problems/interleaving-string/)
    题意：将字符串s1和s2蛇形提取片段构成s3
    总结：动归
    错误：边界条件
+ [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
    题意：判断二叉树是否是二叉搜索树
    总结：二叉树搜索深度优先遍历过程类似于二分查找的过程，不断的缩小范围
    错误：边界溢出
+ [99. Recover Binary Search Tree](https://leetcode.com/problems/recover-binary-search-tree/)
    题意：恢复被交换了2个节点的二叉搜索树
    总结：中序遍历
    + 法一：存储中序遍历的全部节点，判断节点与前后节点的大小关系，找出不符合大小规则的第一个节点和最后一个节点，交换两个节点的值，O(n)空间
    + 法二：使用全局变量last存储中序遍历过程中已访问的最后一个节点，比较当前节点与前一节点的大小关系，同样记录下第一个不符合规则的节点（last），然后不断更新用于存储第二个不符合规则的节点的变量（为了得到最后一个不符合规则的节点），最后交换两个节点的值，O(1)空间
    错误：法二不知道如何记录已访问的最后一个节点
+ [100. Same Tree](https://leetcode.com/problems/same-tree/)
    题意：判断两棵树是否完全相同（结构和数值）
    总结：递归、分治
+ [101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)
    题意：判断一棵树是否中心对称
    总结：递归、分治，判断 节点值是否相等 && leftNode.left和rightNode.right是否对称 && leftNode.right和rightNode.left是否对称
+ [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
    题意：返回二叉树每层节点的值（结果二维）
    总结：（1）利用队列广度优先遍历，null表示某层结束（队列只存储非null节点）；（2）递归方法先序（中序、后序）遍历二叉树，遍历时更新层次深度参数，将节点值添加到层深对应的队列里
+ [103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
    题意：返回二叉树每层节点的值（蛇形）
    总结：类似题目102，根据当前深度的奇偶情况选择插入LinkedList的尾部还是头部
+ [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
    题意：求二叉树最大深度
    总结：f(null) = 0; f(node) = max(f(node.left), f(node.right)) + 1
+ [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
    题意：根据先序遍历、中序遍历结果构造二叉树
    思路：先序首位是根节点root，在中序找到root的位置，中序root左侧为左子树，右侧为右子树，递归构造构造左右子树
+ [106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
    题意：根据中序遍历、后序遍历结果构造二叉树
    思路：后序末位是根节点root，后续思路同105.
+ [108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
    题意：将有序**数组**构造成平衡二叉搜索树
    思路：递归构造。取中间节点作为根节点root，root左边的节点构造成左子树，root右边的节点构造成右子树
+ [109. Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)
    题意：将有序链表构造成平衡二叉搜索树
    总结：（1）中序构造。与108题类似，区别在于链表不能随机访问元素。单链表只能从左到右遍历，因此采用**中序构造**的方法，先构造左子树，同时用公共变量current记录当前构造的链表节点（99题中也用到了该方法），每次中序调用left > root > right过程中，在root访问和right递归调用之间调用next后移，当左子树构造完成时，current指向当前链表节点，构造root，然后调用currenxt = current.next，再递归构造右子树。（2）先序构造，快慢指针找出中间节点，递归。
    错误：不会
+ [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)
    题意：求根节点到叶子节点路径上节点数的最小值
    思路：队列广度优先遍历
+ [112. Path Sum](https://leetcode.com/problems/path-sum/) 
    题意：判断是否存在从根节点到叶子节点的路径和为sum
    总结：回溯
    错误：判断遍历到叶子节点sum是否为0时，用的`sum == 0`，应该用`sum - root.val == 0`；注意当root为null且sum为0时应返回false。
+ [113. Path Sum II](https://leetcode.com/problems/path-sum-ii/)
    题意：找出从根节点到叶子节点的路径和为sum的所有路径
    总结：回溯
    错误：在遍历到叶子节点且`sum - root.val == 0`时，保存当前路径后，未恢复路径（删除刚刚添加的值）直接return
+ [114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
    题意：将二叉树按先序遍历的顺序转换成链表
    总结：
    + 用栈模拟迭代
    + 使用全局变量last记录中序遍历过程中最后访问的元素，在遍历过程中更新last，调用逻辑不易思考，先序遍历last的更新和修改操作在先，而99题采用中序遍历记录last元素，last的更新和修改操作在中。
    + 后序遍历
    错误：没想到栈模拟迭代，没有执行`last.left = null`断开连接
+ [115. Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/)
    题意：给定两字符串s、t，求在s中包含多少个子串t（子串是删除部分字符串得到的）
    总结：动态规划。利用滚动数组(dp[n+1]或dp[2][n+1])优化到O(n)，其中n为字符串t的长度
    错误：动态规划递推公式错误；优化到O(n)的过程中，内外层循环颠倒。
+ [116. Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/?tab=Description)
    题意：将完全二叉树按层次连接成链表，使用常量空间
    总结：从顶向下一层层连接，连接一层后，下次操作时就可以利用建立的链接水平后移
+ [116. Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
    题意：按层次连接满二叉树的每层节点。
    总结：(1)BFS。连接一个节点的左右子节点是很简单的，难点在于连接左子节点的右子节点和右子节点的左子节点。采用从上到下的顺序，先将上层节点连接完成，下层节点的连接可以根据上层节点的连接关系向右迭代。（2）DFS，记录每层最后的节点，last[d].next = root即可。
+ [117. Populating Next Right Pointers in Each Node II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/)
    题意：按层次连接二叉树的每层节点（任意二叉树）
    总结：相比于题目116，难点在于迭代时需要找到下一层头结点。可使用dummy.next保存下层链表的头结点，避免是否是第一次赋值的判断
+ [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
    题意：给定股票各天价格，求只进行一次买卖交易收益的最大值
    总结：迭代记录已遍历过的价格中的最小值，计算当前值与最小值差值，更新最大收益
+ [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
    题意：给定股票各天价格，允许进行任意多次交易（买之前必须已卖出），求收益的最大值
    总结：贪心。收益为正的交易越多越好，将所有价格递增的区间差值累加即可
+ [123. Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
    题意：给定股票各天价格，最多允许进行2次交易，求收益最大值
    总结：动态规划。（1）DP，f[k][i]表示price[0:i]进行k次交易的最大收益。第k次交易卖出可以不发生在第i件物品，或者繁盛在第i件物品。那么f[k][i] = Math.max(f[k][i-1], price[i] - price[j] + f[k-1][j])（0 <= j < i）= Math.max(f[k][i-1], price[i] + (f[k-1][j] - price[j]))。 （2）分两种情况：（a）只进行一次交易：与题目121计算方法相同（b）两次交易：由于两次交易不重叠，所以问题变成左半一次交易最大值和右半一次交易最大值。使用动态规划避免重复计算，同时也能涵盖情况（a）。f[i]表示从0到i一次交易的最大值，g[i]表示从i到n交易的最大值。最后迭代、求和、求最大值。
+ [124. Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
    题意：求二叉树的所有路径（沿父子连线，不能回走）的最大路径和
    总结：自底向上后序遍历，递归返回值和递归更新max的值不同，注意在计算以当前节点为根的子树，且穿过当前节点的路径时，即x = Math.max(0, lmaxEndWithLeft) + Math.max(0, rmaxEndWithRight) + root.val。与0取max的含义是舍弃左边/右边的路径。
+ [126. Word Ladder II](https://leetcode.com/problems/word-ladder-ii/)
    题意：给点源字符串、目的字符串、字符串候选集，通过使用候选集中的字符串，每次改变一个字符，转换成目的字符串。求最小步数对应的所有路径。
    总结：图的最短路径问题 BFS + DFS。利用BFS构建路径上每个单词是由那个单词转换来的，由于一个单词可能有多个单词（用Set保存）转换而来，因此使用distance记录每个单词最短路径长度用于筛选掉走弯路的路径。构建完from表。从endWord利用DFS求解路径即可。
    错误：没有用distance筛选掉弯路，导致DFS超时。
+ [127. Word Ladder](https://leetcode.com/problems/word-ladder/)
    题意：给点源字符串、目的字符串、字符串候选集，通过使用候选集中的字符串，每次改变一个字符，转换成目的字符串。求最小步数。
    总结：图的最短路径问题，广度优先遍历。
    错误：步数的起始值应该为2；由于每次只能修改一个字母，因此在尝试修改当前字符串的每一位时，要把该位置的原字符保留下来，当前位置尝试结束后，要恢复成原来的字符，以免影响下一位的尝试。
+ [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/#/description)
    题意：给定整数数组，求最长的连续序列长度。[100, 4, 200, 1, 3, 2] -> [1, 2, 3, 4]，即4。
    总结：（1）HashMap记录每个值向左右扩散的边界，然后与接壤的区间合并（必须是去扩展其他区间，只扩展自己有问题），每次更新最大区间长度即可。（2）并查集。并查集中使用size数组和maxSize记录每个集合的大小和最大集合大小。一位数组的位置与并查集一位数组的位置一一对应，使用map记录每个元素的下标。当map中已包含某重复元素时，忽略。若当前元素x的相邻x - 1或x + 1在map中存在时，合并并查集中两下标位置。
    错误：方法（1）中只扩展自己会有问题。
+ [130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)
    题意：给定布满X、O的字符数组，将被X包围的O变成X
    总结：（1）BFS。没有被X包围的O一定与边界上的O相连，因此从各边界上的O开始沿着字符O广度优先遍历，并将这些O标记为T，这些能遍历到的O都是没有被包围的。最后再将T变成O，其他的变成X。（2）并查集。二维矩阵位置映射为并查集一维矩阵的位置，申请m * n + 1个空间。下标为m * n的位置为dummy，将边界上的O合并到dummy上，内侧相邻的O向四个方向合并，最后没有与dummy相连的O即被X包围的O，将其修改为X即可。
    错误：深度优先遍历栈溢出
+ [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)
    题意：找出字符串s的所有分割方式，使得分割后的片段都是回文串
    总结：动态规划。（1）对动规结果采用回溯法构造结果（2）空间换时间，保存每个位置到n分割方式，然后遍历扩展。
    错误：动规的计算方向错误，画图！
+ [132. Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/)
    题意：找出字符串s的最小分割次数，使得分割后的片段都是回文串
    总结：动规，大致同上，使用一维数组记录每个位置到结束位置的最小分割次数（当右边界为结束位置时要特殊处理，分割次数为0）
    错误：边界情况测试
+ [134. Gas Station](https://leetcode.com/problems/gas-station/)
    题意：环形加油站，已知各站点加油量和站点间耗油量，起始油量为0，找出可以行驶一圈的起点站（题目满足有唯一解），不存在的话返回-1
    总结：统计出每个站点加油量和耗油量的差值（一系列正负数）。遍历差值，分段求和，但和为负数时，从新统计下一段。当全部差值的和为负数的时候，不存在解。如果存在解的话，最后一段的和一定是非负数，而前面所有段都是负数，因此用变量记录每一段的起始下标，当分段和为负的时候进行更新即可。
+ [135. Candy](https://leetcode.com/problems/candy/)
    题意：N个儿童站一排，给他们发糖。每人有个比例值，要求每人至少一块糖，且相邻儿童中比例高的儿童获得的糖数比邻居要多。求最少发多少块糖。
    总结：贪心法（每次取局部最优，多次贪心得全局最优）。初始化所有小孩的糖果数目为1，从前往后扫描，如果第i个小孩的权值比第i-1个高，那么i的糖果数目等于i-1的糖果数目+1；从后往前扫描，如果第i个的小孩的权值比i+1个小孩高,但是糖果的数目却小或者相等，那么i的糖果数目等于i+1的糖果数目+1。（PS：画折线图，从左到右是的操作是实现升序序列的大小关系，从右到左是满足从右到左的大小关系）
    错误：不会
+ [137. Single Number II](https://leetcode.com/problems/single-number-ii/)
    题意：一列整数中只有一个数出现1次，其他数都出现3次，找出这个出现1次的数。
    总结：位统计法。统计32位整数，各位上统计为1的个数，最后分别模3处理，把所有为1的位相加即可
    错误：统计位的时候位运算出错
+ [138. Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/#/description)
    题意：给定链表，链表节点除label和next属性外，还有random指向任一节点，赋值整个链表。
    总结：（1）O(n)空间，使用Map记录新旧节点的对应关系，先顺序赋值节点的前后关系，然后再遍历一遍赋值random值（2）O(1)空间。新赋值的节点插入原链表到其对应节点后面，然后遍历一遍赋值random值，最后一遍把新赋值的节点提取处理。使用dummy节点简化代码。
    错误：节点赋值关系弄错（后瞻式判断 next.next而非next）。
+ [139. Word Break](https://leetcode.com/problems/word-break/#/description)
    题意：给定字符串s和字符串字典dict，判断能否由字典内字符串构造出s（字典内字符串可重用）
    总结：动态规划。（1）自底向上，O(n^2)。can[i]表示s[i:n-1]能否构造出来。则can[i] |= contains(s[i:j - 1]) && can[j]，初始化边界can[n] = true。（2）自顶向下记忆化，O(n^2)
    错误：过度依赖HashMap超时，HashMap比数组要慢
+ [140. Word Break II](https://leetcode.com/problems/word-break-ii/)
    题意：将源字符串分割，使得分割后的片段均存在于给定的候选集合中
    总结：回溯方法，使用map做备忘录。
    错误：动态规划，从后向前迭代结果是内存超限。而对于带备忘录的回溯方法，回溯方法更加稳重有远见，只有在划分正确的时候才会保存各子段的划分结果。迭代方法过早的保存了大量不必要的结果。
+ [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
    题意：链表判断是否有环
    总结：快、慢指针是否能相遇
+ [142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)
    题意：求带环链表环的起点
    总结：快慢指针第一次相遇后，让新指针从头开始一步步走，同时慢指针也一步步走，当两指针相遇时即为环的起点
+ [143. Reorder List](https://leetcode.com/problems/reorder-list/)
    题意：将链表L0->L1->...->Ln-1->Ln转换为L0->Ln->L1->Ln-1->...
    总结：快慢指针找到中间点，逆序后半段，将后半段插入前半段
    错误：边界条件
+ [145. Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/)
    题意：后序遍历二叉树
    总结：（1）递归遍历（2）类似先序遍历，访问节点的信息**逆序**插入链表，最后链表是后序遍历结果（3）正规迭代方法，难点在于何时向上回溯，一次迭代的处理逻辑如下
    + 向下：靠左一直向下深入，直至不能再向下（到达叶子节点或到达左分支为空、右分支非空的非叶子节点），如果是叶子节点，则访问节点值
    + 向上：判断当前节点是否为栈顶节点的右分支，是的话出栈并访问，直至栈空或不是
    + 栈非空的话，此时表明栈顶节点的右分支还未被访问，切换到栈顶元素的右节点，进入下一次迭代
+ [146. LRU Cache](https://leetcode.com/problems/lru-cache/)
    题意：实现LRU算法（最近最少使用，淘汰最长时间不用的）的缓存
    总结：（1）继承LinkedHashMap，基于access order，重写removeEldestEntry方法；（2）双向链表保存键值对，用map包括键与节点的对应关系，这样删除、增加、移动都是O(1)。注意在增删节点是要更新 map。
    错误：不会
+ [147. Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/)
    题意：插入排序算法对链表排序
    总结：创建dummy节点，作为排序后的链表段。与原链表分开，不需要连接head
    错误：逻辑太乱
+ [148. Sort List](https://leetcode.com/problems/sort-list/)
    题意：链表排序，要求O(nlogn)时间复杂度
    总结：单向链表适合归并排序，双向链表适合快速排序
    错误：误用快排，存在重复元素时有问题
+ [149. Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/)
    题意：给定若干点二维坐标，判断在同一直线上最多的点的个数
    总结：使用斜率判断是否在同一直线上，需要特别考虑相同位置的点和横坐标相等的点的情况。斜率的保存不能用double，需要对分数化简用字符串保存为map的key。
    错误：没有考虑到位置相同的点的情况，斜率用double保存不能精确判断是否在同一个直线上。
+ [150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
    题意：计算反向波兰表示法表示的四则算式
    总结：栈模拟，遇到操作符时从栈里弹出2个数计算，在将结果入栈，直到结束
    错误：出栈时两个数的顺序反了
+ [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/description/)
    题意：将句子中空格分割的单词逆序。
    总结：for (int i = 0, start = 0; i <= s.length(); i++) {char c = i < s.length() ? s.charAt(i) : SPACE;}。需考虑句子首尾的空格，单词间多空格的情况。
+ [152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/?tab=Description)
    题意：求数组最大子序列乘积。
    总结：动态规划。类似于最大子段和问题，多了符号问题，因此迭代求解以nums[i]结尾的最大子段积和最小子段积
    错误：更新subMax和subMin时，需要用临时变量存当前的max和min，否则直接更新就覆盖掉了原值，导致后面计算出错
+ [155. Min Stack](https://leetcode.com/problems/min-stack/#/description)
    题意：实现最小栈，支持O(1)时间复杂度的push、pop、top、getMin。
    总结：（1）O(n)实现。使用long min存储当前最小值，LinkedList<Long> stack存储元素与当前最小值的差值，当元素x入栈时若小于min则更新min。出栈时若栈顶为负数，则说明入栈时对应的元素比当时的min小，这时候出栈要恢复原来的最小值。（2）双栈实现。使用两个栈模拟，栈A为栈基本实现，栈B栈顶始终为当前栈A内最小值，当入栈时，若值小于**等于**栈B栈顶，则也要对栈B进行入栈；出栈时，当栈A出栈元素与栈B栈顶相等，则栈B也要出栈。
    错误：双栈方法中，出栈时判断出栈元素是当前最小值时要转正int，否则Integer不能用==判断会出错
+ [159. Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/?tab=Description)
    题意：给定字符串s，求最多包含2个不同字符的字符串的最大长度。
    总结：HashMap + 滑动窗口。当加入字符后map大小超过2就利用while删除窗口左侧字符直至map大小为2，然后更新max。
+ [160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)
    题意：相交链表求交汇起点
    总结：求两链表长度，长链表对应指针先走长度差值步，然后两链表指针同时开始走，向后迭代，判断两指针是否相等即可
+ [162. Find Peak Element](https://leetcode.com/problems/find-peak-element/#/description)
    题意：给定无重复整数数组，假设num[-1] = num[n] = 负无穷。求任意峰值的下标。
    总结：二分法。处理边界得到mid元素前后的值left,right。然后判断是否峰值，是则放回，不是则二分。[二维峰值问题](http://www.geeksforgeeks.org/find-peak-element-2d-array/)
+ [163. Missing Ranges](https://leetcode.com/problems/missing-ranges/?tab=Description)
    题意：给定已排序整数数组和区间[lower, upper]，求数组中缺失数字构成的区间
    总结：prev记录前一个数（初始值为lower - 1L），after记录当前数（当i == nums.length时为upper + 1，即long after = i == nums.length ? upper + 1L : nums[i];），循环条件为i <= nums.length。注意prev和after都要是long否则溢出
    错误：溢出，思路乱
+ [164. Maximum Gap](https://leetcode.com/problems/maximum-gap/)
    题意：给定无序数组，求排序后相邻两数差值绝对值的最大值，要求O(n)时间/空间复杂度
    总结：（1）基数排序（2）桶排序，根据`(max - min) / (n - 1)`的间距分桶，最大间距出现在相邻两个桶的max和min的差值，或同一个桶的min和max的差值。
+ [165. Compare Version Numbers](https://leetcode.com/problems/compare-version-numbers/)
    题意：比较两个版本号大小
    总结：按`.`分割，从头开始比较整数值。java中`split()`函数的参数是正则表达式，**转义需要加双斜杠`\\`**。较短版本号缺少的位置用0代替
    错误：边界条件，情况考虑不全，1.0与1，01与1
+ [166. Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/#/description)
    题意：给定被除数n和除数d，求整数或小数结果。若结果是循环小数，找出循环节。(1,2)-> 0.5，(2,1)-> 2，(2,3)-> 0.(6)。
    总结：StringBuilder b存储结果，先判断符号，若异号则加入负号。然后将n和d转成正数long，将整数部分n/d加入b，然后求解小数部分。记 remain=n%d。循环处理知道remain为0或找到循环节。（每次循环内n乘10）。循环节的查找需要使用map记录在小数部分求解过程中各remain值的下标，当再次遇到该remain值时说明找到了循环节，且循环节为该map.get(remain)到当前位置。而小数部分的[0, remain)不是循环节。
    错误：不会
+ [168. Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/#/description)
    题意：给定整数转化为Excel Sheet页标题。A > 1，B > 2, ..., AA > 27, AB > 28
    总结：递归。跟26进制完全不同，A并不是0的概念。实际是27进制，A是1，但没有0。因此Z和AA间实际差了2。
+ [173. Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/_
    题意：实现二叉搜索树迭代器，`next()`和`hasNext()`均为`O(1)`时间复杂度
    总结：在`next()`方法实现中序遍历，在出栈操作后break，返回出栈元素的值。
+ [173. Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/#/description)
    题意：实现二叉树搜索树的迭代器：hasNext()和next()
    总结：next方法即对应中序遍历，只是在访问节点值是break出来暂停遍历，返回节点值。
+ [174. Dungeon Game](https://leetcode.com/problems/dungeon-game/)
    题意：给定矩形地图，骑士从左上角出发去营救右下角的公主，每个格子会有健康值的补充或消耗，当骑士健康值为0或负数时死亡。求骑士成功营救公主情况下起始健康值的最小值
    总结：动态规划。dp[i][j]表示在位置该位置要到达右下角至少需要的血量的相反数，计算时可先保证每个格子的健康值最小为0，将左上角的值加1即可。当不需要时，为0。从左上角开始迭代计算，这种方法每个格子利用贪心选择当前从起点到当前最右的路径时，不能达到全局最优。因此需采用从右下角开始反向迭代计算，**从目标出发**，这能保证每次计算都是全局最优的。
    错误：从左上角开始迭代，不能全局最优
+ [179. Largest Number](https://leetcode.com/problems/largest-number/)
    题意：给定整数数组，拼接成字符串，使其对应整数值最大
    总结：转化成`Integer`数组，利用`Arrays.sort`排序，自定义排序比较规则：将o1和o2正序、逆序拼接，比较字符串大小。对排序后的数组拼接即可。
    错误：前导零问题；数值全为0是的特殊情况
+ [187. Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/description/)
    题意：给定ACGT组成的DNA序列，求所有长度为10且重复出现过的子串。
    总结：用长度为10的四进制值作为子串的哈希值，用set判断是否重复出现。
+ [188. Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)
    题意：给定股票各天价格，最多允许进行k次交易，求收益最大值
    总结：动态规划（很难）。（1）DP，f[k][i]表示price[0:i]进行k次交易的最大收益。第k次交易卖出可以不发生在第i件物品，或者发生在第i件物品。那么f[k][i] = Math.max(f[k][i-1], price[i] - price[j] + f[k-1][j])（0 <= j < i）= Math.max(f[k][i-1], price[i] + (f[k-1][j] - price[j]))。（2）[优秀题解](http://www.07net01.com/2015/08/903505.html)。global[i][j]: 前i天进行了j次交易的最大收益，local[i][j]: 第j次交易在第i天完成的最大收益。则有递归公式：local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，~~前一项是前i-1天完成了j-1次交易，今天第i天完成第j次交易，后一项是前i-i天完成了j次交易~~前一项表示第j次交易买入时间在i-1天之前（不含）的最大收益，后一项表示第j次交易买入时间为第i-1天的最大收益；global[i][j]=max(local[i][j],global[i-1][j])，前一项是j次交易最大收益发生在今天第i天，后一项是j次交易最大收益发生在前i-1天。总之，都要分两种状态：今天达成、今天之前达成。
    错误：不会
+ [198. House Robber](https://leetcode.com/problems/house-robber/)
    题意：一排房子，每间房子里有一定的金额，小偷不能偷相邻的房子，求可偷的最大金额。
    总结：动态规划。F(n) = max(F(n), F(n-2) + nums[n])。空间可优化至O(1)
+ [199. Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)
    题意：返回二叉树从右侧看到的节点值序列
    总结：（1）携带深度depth值进行深度优先遍历（先左后右），更新不同深度的值（2）广度优先遍历
+ [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)
    题意：给定0,1矩阵，0代表水，1代表陆地，假设矩阵外全都是水，求岛屿个数。
    总结：以矩阵每个点为起点，图深度优先遍历
    错误：边界条件，矩阵大小为0。图深度优先遍历时忘记排除已经访问过的节点，导致栈溢出
+ [200. Number of Islands](https://leetcode.com/problems/number-of-islands/?tab=Description)
    题意：给定0,1矩阵，求连通岛屿的个数
    总结：（1）深度优先遍历DFS。将已访问的标记下来。当该点为1时进行一次DFS，每DFS一次相当于发现了一个岛屿。（2）并查集
+ [201. Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/)
    题意：求[m, n]区间内所有数按位与的结果，其中0 <= m <= n <= Integer.MAX_VALUE
    总结：如果`m != n`，那么[m, n]内肯定有偶数，按位与结果一定是0。让m,n均右移一位，继续判断，直到m与n相等。并返回m << offset。
    错误：思路不够好
+ [207. Course Schedule](https://leetcode.com/problems/course-schedule/)
    题意：课程安排，课程间存在依赖关系，判断图是否有环
    总结：（1）拓扑排序。统计所有节点的入度，每次删除入度为0的节点，同时更新其他节点的入度。如果能全部删除表示无环，否则有环。（2）深度优先搜索（效率低）。分别以每个节点深搜（visited数组初始均为false），若某个节点深搜过程中，再次访问到了已访问的节点，说明有环。
    错误：使用HashMap<Integer, HashSet<Integer>> adj和HashMap<Integer, Integer> indegree超时，直接用数组更快。注意深搜方法用`for-each`方法遍历ArrayList或HashSet时出现超时。注意1->9，1->9边重复的情况。
+ [208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)
    题意：实现Trie树
    总结：节点属性定义`boolean isWord; HashMap<Character, TrieNode> children;`，不需要记录子节点的字符。`isWord`属性很关键。
    错误：没有定义`isWord`属性
+ [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
    题意：给定正整数序列nums和正整数s，求连续子段和sum满足sum >= s的子段最小长度。
    总结：注意序列元素是正整数。（1）双指针，O(n)。利用双指针i,j锁定区间，根据sum和s的大小关系选择是i++还是j++。（2）二分法，O(nlogn)。统计nums[0:i]子段和得到sum数组，对于sum[j]，利用sum[j] - sum[i] >= s的关系，二分查找sum中满足该关系的最后一个sum[i]，此时子段长度最小。
+ [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)
    题意：课程安排，课程间存在依赖关系，求课程完成的顺序
    总结：拓扑排序。统计所有节点的入度，每次删除入度为0的节点，同时更新其他节点的入度。
+ [211. Add and Search Word - Data structure design](https://leetcode.com/problems/add-and-search-word-data-structure-design/)
    题意：实现一个字典数据结构，支持添加单词，查询是否存在操作，支持通配符'.'
    总结：利用Trie树实现，注意单词遍历结束时isWord的判断
+ [212. Word Search II](https://leetcode.com/problems/word-search-ii/)
    题意：给定字符矩阵和待搜索单词，找出由矩阵中连续（横、竖）字符能够构成的待搜索单词，要求能提前终止回溯，适合大数据量的情况。
    总结：根据单词构建Trie树，节点保存根节点到当前节点组成的单词和子节点(word，children或者isWord、isVisited、children)，实际上这颗统计的是所有单词的前缀信息，后续在深度优先遍历过程中，当前缀不匹配时就终止。进行图的深度优先遍历时，可不使用visited二维数组记录已遍历的结果，可修改board[x][y]为不可能值（如'#'），做为已遍历的标志，深度遍历完该点后再恢复。注意结果有可能重复，因此当找到一个单词后，将其Trie树节点的word置为null，避免下次再次加入结果。
    错误：不会，增加isVisited去重
+ [213. House Robber II](https://leetcode.com/problems/house-robber-ii/)
    题意：环形房子，每间房子里有一定的金额，小偷不能偷相邻的房子，求可偷的最大金额。
    总结：动态规划。F(n) = max(F(n), F(n-2) + nums[n])。由于环形的限制，最大金额一定出现在[0, n-2]或[1, n-1]内。空间可优化至O(1)。
    错误：边界条件，n = 0 或 1时的情况
+ [214. Shortest Palindrome](https://leetcode.com/problems/shortest-palindrome/)
    题意：给定字符串s，允许在字符串s前添加任意字符串使其变成回文串，求长度最小的回文串。
    总结：(1)KMP算法求next数组。记ns = s + "#" + reverse(s)，求ns的next数组即可得到s的最长回文前缀，再将该最长前缀后的字符串逆序添加到s的前面即可(2)从后向前判断s[0:i]是否是回文串，若是则将s[i+1:n-1]逆序添加到到s前即可
    错误：没有处理当s为空串的情况（直接返回空串）i
+ [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/?tab=Description)
    题意：求第k大的数
    总结：利用快排的partition分割数组，如果pivot不是第k个数的话，在从左半或右半递归查找用下标即可。
    错误：注意是第k大，不是第k小
+ [218. The Skyline Problem](https://leetcode.com/problems/the-skyline-problem/)
    题意：给定若干建筑的[start, end, height]，求整体的轮廓。
    总结：扫描线法。所有点包含三种属性：x坐标、高度h、是否是起点。关键问题在按x坐标从小到大排序过程中，确定x坐标相等的不同类点（高度不同或起止点性质不同）排序时的相对顺序。分析可得，当x坐标相等时，同为起点的两个点，应先处理较高者；同为尾点的两个点，应先计算较低者。其他情况时计算的相对顺序任意均可。因此可简化为下面的解法。使用TreeMap记录当前高度集合，其键为高度，值为此高度的建筑的个数。将原建筑三元组信息重建成数组列表List<int[]>，其中元素int[] h为长度为2的数组，h[0]为start或end，当h[0]为start时，h[1] = height,当h[0]为end时，h[1]为-height。对List按h[0]升序排序，若h[0]相等则按h[1]降序排列（必须），然后顺序处理不断更新TreeMap，取当前最大值，若当前最大值和前一最大值发生变化，则将该点加入结果。从而得到轮廓。
    错误：TreeMap中要预先加入(0, 1)，否则当List遍历完后再get会出错
+ [220. Contains Duplicate III](https://leetcode.com/problems/contains-duplicate-iii/?tab=Description)
    题意：给定整数数组，判断是否存在|i - j| <= k 且 |nums[i] - nums[j]| <= t。
    总结：（1）桶排序。按nums[i]-Integer.MIN_VALUE作为分桶值，按照距离t+1分桶，对于当前数nums[i]，可能的解只可能当前桶或相邻桶中。（2）二叉搜索树或使用TreeMap，时间复杂度O(nlogk)。TreeMap方法使用subMap判断是否存在位于区间内的值。注意TreeMap的键要用Long，否则有可能溢出
    错误：不会
+ [221. Maximal Square](https://leetcode.com/problems/maximal-square/)
    题意：0、1矩阵，求由1组成的正方形的最大面积
    总结：动态规划。记f[i][j]为以matrix[i][j]为右下角的正方形的最大边长。当matrix[i][j] = 0时，f[i][j] = 0;否则f[i][j] = min(f[i - 1][j - 1], f[i][j - 1], f[i - 1][j]) + 1。用f[i][j]不断更新max，最后返回max * max即可
    错误：返回了max，应该返回max * max。
+ [222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)
    题意：求完全二叉树节点个数。
    总结：记所求为f(root)。先求左、右子树**靠左深搜**的高度lh和rh。若lh = rh，说明左子树是满的，则f(root) = (1 << lh) + f(root.right)；否则，说明右子树是满的，则f(root) = f(root.left) + (1 << rh)
    错误：遍历超时。
+ [223. Rectangle Area](https://leetcode.com/problems/rectangle-area/)
    题意：求两矩形覆盖的总面积
    总结：面积和减去重叠部分面积，注意无重叠情况的处理
    错误：**加减乘除溢出溢出溢出溢出！！！**
+ [224. Basic Calculator](https://leetcode.com/problems/basic-calculator/)
    题意：实现计算器，算式中包含加减号、负号、括号
    总结：栈模拟。`(`相当于方法调用，需要入栈当前环境；`)`相当于方法返回，需要出栈。result记录全局结果或暂存括号内结果，sign（1,-1）表示当前数字的前面的运算负号。当遇到数字时，一直向后直到遇到非数字字符或结束，就可以得到当前操作数，乘以负号sign加到result上。当遇到`(`时，当前result和sign入栈，result置0，此时用result计算括号内的结果。当遇到`)`时，出栈之前的符号和原result值，`result = result * stack.pop() + stack.pop()`更新结果。
    错误：没有清晰的思路
+ [225. Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)
    题意：用队列模拟栈
    总结：队列中元素出队顺序始终保持与出栈顺序一致。使用两个队列q, aq，每次入栈操作时，把q中的元素全部移入aq，然后将新元素入队q，再把aq元素移回q即可
+ [229. Majority Element II](https://leetcode.com/problems/majority-element-ii/?tab=Description)
    题意：给定整数数组，找出其中出现次数超过n / 3（向下取整）的所有整数
    总结：Boyer-Moore Majority Vote algorithm。同归于尽方法，设置两个变量p1,p2及其对应计数c1,c2，最多有2个这样的数，剩下即使c1,c2大于0也不能说明其次数超过n/3，需重新统计。要注意赋值逻辑优先级，以防两变量值相等。
    错误：赋值逻辑错误导致两变量相等，没有重新统计次数。
+ [230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
    题意：求二叉搜索树第k小的值
    总结：（1）中序遍历，迭代。（2）递归，countNode计算左子树节点个数lcount，如果lcount = k - 1，则当前根节点是第k小的值，直接返回；如果lcount > k - 1，则递归左子树找第k小的值，否则递归右子树找第k - 1 - lcount小的值。
+ [231. Power of Two](https://leetcode.com/problems/power-of-two/)
    题意：判断一个数是否是2的某次幂
    总结：（1）n > 0 && (n & (n - 1)) == 0 （2）如果非整数直接返回false，否则计算1的位数是否为1
    错误：（1）忽略了n > 0的限制（2）i一直左移导致溢出
+ [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)
    题意：用栈模拟队列
    总结：栈中元素出栈顺序始终保持与出队顺序一致。使用两个栈s,as。两个栈之间转移一次数据，相当于逆序一次，两次的话，就会变成原顺序。每次入队列时，把s中的元素全部移入as，然后将新元素入栈s，再把as元素移回s即可
+ [233. Number of Digit One](https://leetcode.com/problems/number-of-digit-one/)
    题意：统计[0, n]闭区间内所有数中1出现的次数
    总结：统计个位、十位、百位等各位为1的数的个数，然后求和。需要分bit = 0, bit = 1, bit >= 2三种情况处理
    错误：思路不清晰，不会
+ [235. Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
    题意：二叉搜索树BST求两个节点的最低公共祖先LCA
    总结：递归或迭代。LCA满足(p.val - lca.val) * (q.val - lca.val) <= 0。注意可以等于0，即其中一个节点是另一个节点的祖先
+ [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
    题意：二叉树求两个节点的最低公共祖先LCA
    总结：递归。递归终止条件，当root == null 或root等于其中一个节点时返回root；递推关系：递归调用左子树、右子树返回left、right。当left == null时直接返回right（因为两个节点都在又子树）；当left != null && right == null时返回left；当left != null && right != null返回root。
+ [237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)
    题意：给定链表某个节点（非尾节点）的引用node，删除该节点（值）
    总结：直接将node后一节点的值覆盖当前节点，然后删除后一节点。
+ [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
    题意：给定数组和滑动窗口大小k，窗口从左滑向右，返回窗口在各位置窗口内元素的最大值
    总结：（1）使用TreeMap包括窗口内各元素的个数，调用TreeMap的lastKey()方法可获得当前窗口内最大值，时间复杂度O(nlogk)（2）使用双端队列，队列内元素非升序，队列始终保存窗口内元素可能会成为后续最大值的元素的下标（过时元素每次迭代时从队列头剔除）。迭代到nums[i]时，比较nums[i]与队尾元素的大小，若nums[i]较大，则队尾剔除，再次判断知道队列为空或nums[i]小于**等于**队列尾元素。实际deque内的元素始终保持非升序，队列头即为当前窗口最大元素。此题与最小栈类似，实际上是利用deque实现了一个**最大队列**。
    错误：思路太乱，不会
+ [240. Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/)
    题意：二维矩阵，每行和每列都是递增的，查找矩阵中是否包含某个数target
    总结：以右上角[i,j]元素p为判断基准，若p == target，直接返回；若p > target，由于p所在列元素都大于等于p，因此j--;若p < target，由于p所在行都小于等于p，则i++。若迭代整个矩阵后不能找到则返回false
    错误：思路错误，矩阵中心的元素与target的大小关系不能进一步缩小矩阵范围
+ [241. Different Ways to Add Parentheses](https://leetcode.com/problems/different-ways-to-add-parentheses/)
    题意：给定包含+、-、*的算式，求各种加括号方式后的结果值
    总结：分治。以每个运算符为界限，将算式分成左半和右半，分别递归计算左半和右半的结果值，返回两个列表leftList、rightList。然后对两列表中各选一元素进行运算，得到当前算式的一个结果。若当前算式中无运算符，则说明是一个操作数，直接返回仅包含其整数值的列表即可。实际上加括号即不同的划分方式。
    同类：[95. Unique Binary Search Trees II](https://leetcode.com/problems/unique-binary-search-trees-ii/)
+ [246. Strobogrammatic Number](https://leetcode.com/problems/strobogrammatic-number/?tab=Description)
    题意：判断一个数是否是旋转对称的。
    总结：用map存储对称关系(0,0), (1,1), (8,8), (6,9), (9,6)。双指针对照判断即可。循环条件为i <= j
+ [247. Strobogrammatic Number II](https://leetcode.com/problems/strobogrammatic-number-ii/?tab=Description)
    题意：求长度为n的所有旋转对称数字
    总结：分治。先构造出n - 2的所有旋转对称数字，然后在首位添加满足对称关系的两个字符即可。需要考虑前导零问题，当 n = 1时不能返回6和9.
+ [249. Group Shifted Strings](https://leetcode.com/problems/group-shifted-strings/?tab=Description)
    题意：字母a > b > ... > z > a具有循环右移属性。给定若干字符串，对其分组，使得同组字符串彼此都可以循环右移得到。
    总结：对每个字符串生成一个hash，其值是所有相邻两字符差值拼接起来的字符串，用特殊符号|分割，注意当差值为负数时加上26转换成整数。否则不能判断出az和ba是同组。使用Map<String, List<String>> 分组。
    错误：差值为负数时没有转换成整数，导致az和ba这类判断错误。
+ [251. Flatten 2D Vector](https://leetcode.com/problems/flatten-2d-vector/?tab=Description)
    题意：给定List<List<Integer>> vec2d，实现迭代器完成vec2d的迭代。
    总结：使用两个迭代器，outIt和inIt分别迭代外层list和list内的Integer。
+ [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/?tab=Description)
    题意：给定若干会议的起止时间，求所有会议至少需要多少会议室。
    总结：贪心算法。（1）按会议开始时间排序，每一会议都肯定会有一间会议室，只需要充分利用这一间会议即可。剩余冲突的会议递归求解需要的会议室的数量。（2）使用堆。堆内存储各会议室的开始时间和当前结束时间，堆按end时间排序，会议按start时间排序，对于每个会议，每次从堆内取出最早结束的会议室，如果该会议能在此会议室举行（start >= end），则更新此会议室的结束时间，否则将该会议加入堆中（因为最早结束的会议室都无法举行此会议，其他会议室肯定也不行），表示新增一间会议室，其开始和结束时间与当前会议相同。最终堆的大小即会议室所需的个数。
    错误：按结束时间排序，只能使的当前会议室能举行最多的会议，但不能保证全局最优。
+ [256. Paint House](https://leetcode.com/problems/paint-house/description/)
    题意：n个房屋，每个房屋可以涂成红绿蓝中的一种，但相邻的房屋不能颜色相同，已知不同房屋涂不同颜色的代价，求涂抹房屋的最小代价。
    总结：DP。
+ [259. 3Sum Smaller](https://leetcode.com/problems/3sum-smaller/?tab=Description)
    题意：给定整数序列和target，求满足i < j < k且nums[i] + nums[j] + nums[k] < target的三元组的个数。
    总结：排序 +　双指针。
+ [260. Single Number III](https://leetcode.com/problems/single-number-iii/)
    题意：只有两个数分别出现一次，其他数均出现2次。找出这两个数。
    总结：对所有数异或求出两个数异或的结果，找出异或结果中为1的某一位，对所有数根据这一位是否为1分成2组，每组自行异或。最后两个分别异或的结果就是这两个数。
    错误：一直从a|b和a^b反求a,b的角度想，不会。
+ [261. Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/#/description)
    题意：给定[0, n - 1]这n个节点和若干无向边，判断此图是否是合法的树结构。
    总结：图是合法的树结构需满足：任意两点间只有一条路径、无环。使用并查集。并查集集合里的元素间存在路径，若union操作的两个节点本身在同一集合，说明此时一定有环，直接返回false。若最终并查集内只有一个集合，则说明是合法的树结构。
+ [264. Ugly Number II](https://leetcode.com/problems/ugly-number-ii/)
    题意：找出第n个丑数。非正数不是丑数，1是丑数，因子只有包含2,3,5的数也是丑数。
    总结：声明nums[n + 1]数组存储第i个丑数，i,j,k分别代表乘2,3,5的三种方式，从nums[1]开始分别乘以因子来生产下一个候选丑数，i,j,k用于记录各自方式生产下一个丑数的进度（下标），分别初始化为1，每次找下一个丑数时，从i,j,k乘对应因子后的数中选择最小的作为当前丑数，同时对应的下标加1，注意有可能i,j,k生产出的丑数相等，因此可能都需要加1.
+ [269. Alien Dictionary](https://leetcode.com/problems/alien-dictionary/#/description)
    题意：给定按新型字典序排序好的字符串数组，求其字母的顺序。
    总结：图、拓扑排序。两两单词比较，得到两个字母的相对顺序，对应于图的一条边，需要注意这样的边可能有多条，因此使用HashMap<Character, HashSet<Character>> adj存储邻接表，计算每个点的入度时需判重避免重复计算。最后拓扑排序，每次移除入度为0的点，并更新其邻居点的入度，同时将其入度置位1，避免影响下次判断。另外，由于包含哪些字母位置，因此可预先遍历所有单词的所有字母，初始化adj和indegree为空。
    错误：获取有向边的思路太复杂。
+ [271. Encode and Decode Strings](https://leetcode.com/problems/encode-and-decode-strings/?tab=Description)
    题意：实现字符串数组和字符串之间的编码和解码。
    总结：数组中每个字符串的编码格式：长度 + 分隔符 + 字符串；长度可用16进制缩短长度。解码时从左到右先找到分隔符，然后确定长度，然后取出字符串。
+ [273. Integer to English Words](https://leetcode.com/problems/integer-to-english-words/#/description)
    题意：将非负整数转化成英文
    总结：每三位作为一组处理，每次拼接字符串时要考虑后半字符串是否为空，空的话省略空格。实现函数repr（`return s.equals("") ? "" : " " + s`;）。
    错误：边界条件0未考虑，当某一部分为空时，对应的空格应该省略
+ [274. H-Index](https://leetcode.com/problems/h-index/#/description)
    题意：给定作家每篇论文的引用数，定义作家的h索引为：如果作家N篇论文中的h篇论文每篇至少有h引用，且其他N - h篇论文每篇引用数都小于等于h，则作家的索引为h。求作家的最大索引。
    总结：题意可转化为：求数组中满足h个数的值都大于等于h，且其他数均小于h的h最大值。对数组排序，从左到右测试当前值是否大于等于右侧元素的数量（包括自身）。是则返回右侧元素的数量，否则继续判断。实际上h的可能取值是[0, n - 1]。题目一定存在解。
    错误：从右向左求解，实际上求解出的是最小的h，错误的返回了当前元素的值，而非右侧元素个数。
+ [275. H-Index II](https://leetcode.com/problems/h-index-ii/#/description)
    题意：与274类似，只是给定的引用数是有序的，求最大的h。
    总结：有序数组值递增，而下标递减，因此可以用二分法求解。循环条件l <= r，返回值n - l。
    错误：边界不对。
+ [276. Paint Fence](https://leetcode.com/problems/paint-fence/?tab=Description)
    题意：n个面板排成一排，用k种颜色涂面板，要求最多连续2个面板允许涂成相同颜色，共有多少种涂抹方案。
    总结：动态规划。定义每个面板有两种状态，f[i][0]表示[0:i]涂抹后i和i-1颜色不同的方案数，f[i][1]表示[0:i]涂抹后i和i-1相同的方案数。则有f[i][0] = (f[i-1][0] + f[i-1][1]) * (k - 1)，f[i][1] = f[i - 1][0]。初始化f[0][0] = k，f[0][1] = 0。
    错误：不会
+ [279. Perfect Squares](https://leetcode.com/problems/perfect-squares/?tab=Description)
    题意：给定正整数n，将其分解成n个整数，每个整数都是平方数，求n的最小值
    总结：动态规划。f[n] = min(f[n - i * i] + 1)，其中i满足i * i <= n
    错误：思路不清晰
+ [279. Perfect Squares](https://leetcode.com/problems/perfect-squares/)
    题意：将n分解成多个平方数的和，求各种分解方法中平方数个数的最小值
    总结：动态规划。使用回溯方法会出现大量的重复计算。使用动规自底向上或自顶向下（记忆化）均可
    错误：大量重复计算导致超时
+ [280. Wiggle Sort](https://leetcode.com/problems/wiggle-sort/?tab=Description)
    题意：对数组摆动排序，使其满足 nums[0] <= nums[1] >= nums[2] <= nums[3]
    总结：（1）贪心交换。针对奇偶位置，不满足大小关系就前后交换。（2）排序，重排
    错误：排序效率低
+ [281. Zigzag Iterator](https://leetcode.com/problems/zigzag-iterator/?tab=Description)
    题意：给定两个列表，实现Zigzag类型的迭代器
    总结：申请长度为2的Iterator数组，使用循环数组的思想切换迭代器
+ [282. Expression Add Operators](https://leetcode.com/problems/expression-add-operators/)
    题意：给定由数字组成的字符串和目标值，可以任意位置添加+、-、*符号，求全部可行的添加方法，使得添加后的算式的结果等于目标值。
    总结：回溯法。需要记录上一次的算式片段的值，用于在当前方法中计算乘法（因为乘法的优先级较高）。边界条件，前导0的操作数非法。
    错误：不会
+ [286. Walls and Gates](https://leetcode.com/problems/walls-and-gates/?tab=Description)
    题意：二维矩阵里有障碍物-1,门0,空房间Integer.MAX_VALUE，将空房间的值更新成里最近的门的距离。
    总结：（1）BFS。将所有门加入队列，对队列中每个元素，处理4个方向，只有当下一个位置的值为Integer.MAX_VALUE时才更新其下一位置值，并将下一位置加入队列（2）DFS。从门出深搜，更新空房间的值。visited数组在向上回溯时需要恢复。
+ [287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/?tab=Description)
    题意：给定整数数组，长度n + 1,元素值域[1, n]，有且仅有一个出现多次的元素，求该元素。
    总结：（1）基于值的二分，统计<=值m的元素个数然后二分，O(nlogn)（2）链表求环起点问题。必定有个节点入度为2。实际上数组对应一种映射关系，以fast = 0, slow = 0开始，因为值域是[1, n]，0不在范围内，所以0不在环内
    错误：不会
+ [288. Unique Word Abbreviation](https://leetcode.com/problems/unique-word-abbreviation/?tab=Description)
    题意：假定abcde的简写规则是a4e这样，给定字典和一个字符串s，判断字典内是否没有非s串的简写与s相同（独一无二）
    总结：先求出字典内各字符串的简写all，对于s的简写实际上有3种状态，all中没有该简写，all中只有一个该简写，all中有多个该简写，只有当没有简写和有一个简写且字典内对应字符串就是s本身时才是独一无二的。使用HashMap<String, String>记录key和对应的原串，在处理字典内的简写时当出现key相同但对应的原串不同是，把key的值置为""，标识冲突。
    错误：题意理解错误，没有考虑字典内重复串的情况。思路复杂
+ [289. Game of Life](https://leetcode.com/problems/game-of-life/?tab=Description)
    题意：生存游戏。给定01二维矩阵,0表示死亡，1表示存活。8个邻居（最多）中存活的数量决定了当前位置下一轮的生死情况。求矩阵下一状态。
    总结：因为矩阵的值是0或1.因此可以次低位表示下一轮的生死状态，这样的修改不会影响临近位置此轮的生死决定。最后再根据次低位重新更新矩阵。
+ [292. Nim Game](https://leetcode.com/problems/nim-game/)
    题意：两人游戏，一堆石子，每次从中拿出1-3个，拿走最后一颗石子的人获胜。给定石子个数，判断第一个拿的人能不能赢，两人每次都采用最优策略。
    总结：从1开始举例很容易发现规律。石子总数为4的倍数时，第一个人总是输，因为无论第一个拿走几个，第二个都可以然剩下的数变成4的倍数。数学归纳法: f(4) = false; f(4n) = f(4 * (n - 1))，按最后对齐的每四个石子实际上都是2组拿完。
+ [293. Flip Game](https://leetcode.com/problems/flip-game/?tab=Description)
    题意：给定只包含+和-的字符串，可以把连续的++转换成--。求一次转换后所有可能的结果。
    总结：转化成字符数组，然后判断连续字符是否都是++，是的话就修改成--，创建新的字符串，然后再恢复成++，判断下一位置。
+ [294. Flip Game II](https://leetcode.com/problems/flip-game-ii/?tab=Description)
    题意：给定只包含+和-的字符串，每次把连续的++转换成--，若当前选手翻转后不能再进行翻转，则对手输。判断先手者是否能保证一定能赢。
    总结：实际上搜索空间对应一颗与或树。（1）canWin(String s)表示先手着是否能赢，对s做所有可能的一次翻转得到t，若至少存在一个canWin(t)为false，则直接返回true，否则返回false（2）严格按照与或树的规则自底向上求解。
+ [295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)
    题意：设计数据结构，支持添加一个数，找出中位数两方法。
    总结：使用一个小根堆和一个大根堆。小根堆存储较大的一半数字，堆顶是较大数中的最小值；大根堆存储较小的一半数字，堆顶是较小数中的最大值。每次添加一个数时，先加到大根堆中，再从大根堆中取出堆顶放入小根堆，如果此时小根堆元素个数多余大根堆，则再从小根堆中取堆顶放入大根堆。这样的一次流程实际上是一次平衡，保证了两堆存储的都是该存储的数。技巧：可以用两个小根堆实现，通过在数字前加符号即可，可以用小根堆模拟大根堆。
    错误：不会
+ [297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)
    题意：实现类，完成二叉树的序列化和反序列化方法
    总结：null节点用字符串"null"表示，不同节点间用","分隔。（1）BFS按层次遍历。（2）先序遍历。**使用队列存放节点的值**，每次取出一个节点用于创建，递归过程中就不再需要用int ix表明已经处理到的位置了。
    错误：先序遍历方法没想到使用队列
+ [297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)
    题意：二叉树序列化和反序列化
    总结：先序遍历。null用特殊字符#表示，不同节点值用`,`分隔。与二叉树的序列化、反序列化相同。反序列化时使用队列做全局变量。
    错误：中序遍历方法不同BST序列化字符串可能相同，因此反序列化会有问题
+ [298. Binary Tree Longest Consecutive Sequence](https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/?tab=Description)
    题意：求二叉树由上向下最长递增连续序列的长度
    总结：后序遍历。每次返回以当前节点为起始点的序列最大长度，不断更新全局变量max
+ [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
    题意：给定无序数组，求递增子序列的最大长度（不要求连续）
    总结：（1）动规。依次求解并保存以每个位置结尾的最大长度，每个位置的求解都需要遍历小于该位置的所有已得解，满足关系的已得解加1。O(n^2)。（2）动规+二分查找。O(nlogn)。不懂
    错误：只会O(n^2)解法
+ [301. Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)
    题意：给定包含括号和字母的字符串s，删除最少的括号使之合法，求所有这些合法的字符串
    总结：广度优先搜索。借助队列进行BFS。删除s任意位置的括号并将结果入队，使用visited集合记录入队过的字符串，避免出现重复结果。出队时使用整数判断是否合法。当出队的字符串比已得结果字符串长度短时直接退出返回。
    错误：变量名太简单容易混用
+ [303. Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)
    题意：设计数据结构，传入整数数组nums，提供sum(i,j)方法用于返回nums[i...j]的和。数组不会变且该方法会被频繁调用。
    总结：一维数组sum存储nums[0...i]的和，则所求sumRange(i, j) = sum(j) - sum(i - 1)。注意i - 1溢出，可以申请new int[n + 1]，用sum[i + 1]表示num[0...i]的和。此思路与二叉树利用各节点到根节点的路径和之差求节点间路径和的思路类似。
    错误：使用了二维数组；一维数组解时nums[i]与sum[i+1]的对应关系弄混了
+ [304. Range Sum Query 2D - Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/)
    题意：设计数据结构，传入二维数组，提供sum(i1, j1, i2, j2)方法用于返回(i1, j1)和(i2, j2)两点确定的矩形区域内值的总和。数组不会变且方法会被频繁调用。
    总结：二维数组sum存储每个点与matrix[0][0]确定的矩形区域内整数的和，用D - B - C + A的公式间接求解。同样多申请一维空间，简化代码。
+ [305. Number of Islands II](https://leetcode.com/problems/number-of-islands-ii/#/description)
    题意：给定m * n的二维矩阵，0表示水，初始化全0，然后给定若干数对表示依次将数对对应的位置置为陆地，求每次操作后陆地的个数。
    总结：并查集。每次加入节点，先将陆地数count加1，然后判断是否需要union，union时count减1。
+ [306. Additive Number](https://leetcode.com/problems/additive-number/)
    题意：判断由数字组成的字符串是否是一个可累加字符串。如112358，199100199
    总结：O(n^2)。前导0情况特殊处理。循环找到每一个起始方式，一旦起始方式确定了，那么是否可累加就确定，因此后续判断只需迭代，无序回溯。判断每种方式是否能达到累加效果。
    错误：字符串转整数的时候溢出。
+ [307. Range Sum Query - Mutable](https://leetcode.com/problems/range-sum-query-mutable/?tab=Description)
    题意：求数组区间和，支持更新元素
    总结：线段树。根据数组自底向上构造线段树（build(int[] nums, int start, int end)），区间的边界值对应数组下标
    错误：没有考虑数组为空的情况（直接返回，不构造线段树）
+ [307. Range Sum Query - Mutable](https://leetcode.com/problems/range-sum-query-mutable/)
    题意：设计数据结构，传入整数数组nums，提供sum(i,j)方法用于返回nums[i...j]的和，提供update(i, val)方法修改元素nums[i]的值为val，数组元素会修改且该sum方法会被频繁调用。
    总结：（1）将nums分段，段的长度和段的个数均为ceil(sqrt(nums.length))。用数组b记录每段的和。修改元素时修改nums[i]和元素在b所在段的值；借助b求和。注意当sum(i,j)发生在同一段时要特殊处理。（2）线段树。a）树。自底向上构造线段树，树节点属性包含start, end, sum, left, right，叶子节点的sum是元素本身的值。更新树的时候也是自底向上按对应叶子节点到根节点的路径更新各节点的sum值。求区间和sum(i, j)时，当i,j分别与当前节点的start,end相等时，直接返回sum，否则分解问题求解。b）数组模拟。tree[i]的两个子节点是tree[2i]和tree[2i + 1]。数组模拟在求解区间和sum(i,j)时需要修正i，j。使得i总是左子树位置，j总是右子树位置。
+ [308. Range Sum Query 2D - Mutable](https://leetcode.com/problems/range-sum-query-2d-mutable/#/description)
    题意：给定二维矩阵，实现数据结构支持update()更新某元素的值，sumRegion()方法返回某区域的和。
    总结：二叉索引树，由一位变成了二维，思路基本一致。更新某值时，两层嵌套循环进行蔓延。时间复杂度O(logm * logn)
    错误：不会
+ [309. Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
    题意：给定股票各天价格，允许进行任意多次交易（买之前必须已卖出），且卖出后的第二天不能立刻买入，求收益的最大值
    总结：动态规划。确定状态和递推式。大体上分为两种状态：已买入和已卖出。如果只设定这两种状态的话，前一天与当天的递推式不能约束到“卖出后的第二天不能立刻买入”。因此将已卖出状态分解为当天卖出（明天不能买入）和当天之前卖出（明天可买入）。这三种状态可以满足题目的约束。然后再画出状态转移图（转移线上是动作）即可。注意：由于第一天之前是不可能有买入状态的，所以将买入状态的起始值设为Integer.MIN_VALUE。或者第一天的在循环外预处理。
    错误：没有考虑第一天前买入状态不可能的情况。
+ [310. Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/)
    题意：给定带有树特性的无向图，选择任一节点作为根节点可构成一颗树。求这些树中全部高度最小的树对应的根节点。
    总结：实际上所求的根节点只可能有1个或2个。所求根节点在无向图最长的一条路径上，最长路径长度为奇数时，根节点有1个；偶数时有2个。求解方法：每次迭代删除全部的叶子节点，知道最终剩余节点数小于等于2个。注意，不能边删除边迭代。
    错误：深度优先搜索超时
    知识点：
    + 树是一个任意2个节点间有且仅有一条路径的无向图。
    + 任何有n个节点，n-1条边的连通图是一棵树
    + 树的高度是叶子节点到根节点最长路径上边的数量
+ [312. Burst Balloons](https://leetcode.com/problems/burst-balloons/)
    题意：一排气球，每个气球上标有一个整数，将气球依次戳破，戳破第i个气球得到`nums[left] * nums[i] * nums[right]`个硬币，且戳破后，被戳破气球左、右气球变成相邻。求戳破全部气球可得硬币的最大值。第一个气球的左侧和最后一个气球的右侧，可任务分别有一个值为1的虚拟气球。
    总结：动态规划。以相反的思路求解问题。为方便，重新申请长度为n + 2的数组arr，首元素和尾元素分别置位1，其他元素的值对应原气球的值。设f[i][j]为气球b[i...j]戳破[i + 1, j - 1]区间内的气球可得硬币的最大值，以最后被戳破的气球为界将气球分成两半，则有
$$f[i][j] = max(f[i][k] + f[k][j] + arr[i] * arr[k] * arr[j]), 其中i < k < j$$
。循环求解时，最外层为i,j的距离（从2开始），次外层为i。此题目与矩阵连乘很相似。
+ [315. Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)
    题意：给定一整数数组，求每个数右侧小于当前数的整数个数。
    总结：（1）二叉搜索树。节点存储当前值、重复个数、左子树元素个数（含重复）。插入和查询可以合并到一起处理。逆序插入各数组元素。深搜插入节点过程递归调用传参时需传递目前已找到的小于所求数的整数的个数preCount。需要注意的是，当深搜向右分支延伸时，preCount在加上当前节点重复个数的同时，还要加上当前节点左子树元素的个数。（2）线段树。节点存储区间[start, end]，区间内整数的数量count。同样插入和查询可以合并到一起处理，深搜插入节点过程递归调用传参时需传递目前已找到的小于所求数的整数的个数preCount。
+ [316. Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/)
    题意：删除多余的重复字符，使所有出现的字符只出现一次，找出所有结果中字典序最小的那个。
    总结：（1）栈，O(n)。栈内自底向上呈递增。解决重复入栈和栈内元素可替换条件的问题。先统计各字符个数，使用visited数组记录每个字符串是否已入栈。迭代过程中对应字符的计数减1，若字符已入栈则直接处理下一字符。当当前元素比栈顶元素小且栈顶元素的计数不为0时，栈顶出栈并更新对应visited值为false，循环直至条件不满足。然后将当前元素入栈，visited值置为true。最后栈内元素即为所求。（2）O(n^2)解法。先统计每个字母的个数，遍历字符串,记录当前遇到最小的字符串的下标pos，每次对应字符的统计个数减1，当遇到第一个个数为0的字符时，从开始到当前位置最小的字符s[pos]就是所求字符串的第一个字符。然后将后续字符串中的x删除。递归求解后续字符串，与字符x拼接即为所求。
    错误：以a-z的顺序求解是不可行的。
+ [317. Shortest Distance from All Buildings](https://leetcode.com/problems/shortest-distance-from-all-buildings/#/description)
    题意：给定二维矩阵，0空地，1房子，2障碍，求空地到其他所有房子的距离和的最小值。
    总结：BFS。对所有可能的空地进行BFS，记录下每个空地到全部房子的距离和，选最小值。BFS时队列元素存储x, y和到起始点的距离d。
    错误：不会，只对0空地处进行BFS。
+ [318. Maximum Product of Word Lengths](https://leetcode.com/problems/maximum-product-of-word-lengths/)
    题目：给定一些字符串，求不含公共字符的两个字符串长度乘积的最大值，字符串中只包含小写字母
    总结：将每个字符串转换成一个26位的整数，将字符串是否包含某个字母映射到整数的某一位。最后通过与运算即可判定两字符串是否有公共字符。实际上，这类似与hash函数。
    错误：没有想到使用位运算
+ [319. Bulb Switcher](https://leetcode.com/problems/bulb-switcher/)
    题意：有n盏灯，初始状态为关闭。进行n轮操作，第i轮操作中每i盏灯切换一次状态（on > off, off > on）。求n轮操作后有多少灯是亮的。
    总结：举个例子。不难发现规律。这n轮操作中，当进行第i轮操作时，若灯的编号（从1开始）是i的倍数，则切换该灯的状态。因此只需要求每盏灯的因子个数（非重复）即可，编号因子个数为奇数的灯最终打开，其他灯关闭。正整数的因子都是成对出现的。只有平方数的因子个数是奇数，因此只需要求1~n内有多少个平方数即可。实际上n的平方根向下取整即为1~n中平方数的个数。
+ [320. Generalized Abbreviation](https://leetcode.com/problems/generalized-abbreviation/?tab=Description)
    题意：给定字符串word，求所有可能的省略表示。如'word'的所有省略为["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
    总结：回溯，组合树。即每个节点对应于每个位置是否省略。连续的省略需要合并，因此连续省略的个数在递归中要传递，当遇到不省略的字符时停止。
    错误：重复回溯导致超时。
+ [321. Create Maximum Number](https://leetcode.com/problems/create-maximum-number/)
    题意：给定两个数组，元素都是个位数，从两数组中选出整数组成最大的k位数。要求同一数组内取出的整数在k位数中的相对顺序与在原数组中相同
    总结：贪心。组合成k位数，遍历每一个种组合情况求最大的。合并两个子序列时当两个值相等时要继续比较后面的值，选后面值较大的那个。
    错误：不会
+ [322. Coin Change](https://leetcode.com/problems/coin-change/)
    题意：给定无数个不同面额的零钱和需要兑换的金额amount，求所有兑换方式中硬币数量的最小值。
    总结：动态规划。（1）自底向上，计算[1, amount]中所有值的最小兑换方式（2）自顶向下（记忆化）。
    错误：剪枝有问题，不能剪枝？
+ [324. Wiggle Sort II](https://leetcode.com/problems/wiggle-sort-ii/)
    题意：对数组nums摆动排序，使得结果`nums[0] < nums[1] > nums[2] < nums[3]....`
    总结：首先对数组排序，从右向左偶数索引放前一半小数，从右向左奇数索引放后一半大数。这是O(nlogn)时间复杂度、O(n)空间复杂度的解法。还有O(n)、O(1)的解法，不会。
    错误：必须都从右向左放，如果从左向右放，当数组较小且分界处的数相等时会导致，相等的数相邻。如果[4,5,5,6]。
+ [326. Power of Three](https://leetcode.com/problems/power-of-three/)
    题意：判断一个int整数是否是3的某次幂。
    总结：由于输入是int，正数范围是0-2^31，在此范围中允许的最大的3的次方数为3^19=1162261467，由于3是质数，所以只要看这个数能否被n整除即可。
+ [327. Count of Range Sum](https://leetcode.com/problems/count-of-range-sum/)
    题意：给定整数数组，求连续子段和s(i,j)(i <= j)在区间[lower, upper]内的子段和的个数。要求复杂度低于O(n^2)
    总结：先求nums[0:i]的区间和sums,问题转换为求sums的数对sums[i]和sums[j]满足lower <= sums[j] - sums[i] <= upper。与求逆序对个数的问题基本一致。（1）分治，类似于归并排序。利用归并排序思路即可。注意在合并函数里遍历左半段每个元素，用两个索引找到在右半段内满足条件的索引范围，然后随着左半段元素的移动，向右更新范围。转化成sum[j] - sum[i]后，问题就会变得索引无关。（2）二叉搜索树。
    错误：不会及边界问题。
+ [328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)
    题意：将链表重构，使奇数索引处的节点都在链表前一半，偶数索引处的节点都在链表后一半。
    总结：（1）创建两个dummy节点，对原链表节点分类。（2）不需要duumy，直接分类。
+ [329. Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)
    题意：二维整数矩阵，求最长递增路径长度
    总结：深度优先遍历 + 记忆化。
+ [330. Patching Array](https://leetcode.com/problems/patching-array/)
    题意：给定有序数组nums和整数n，向数组中加入整数使[1, n]内的所有数均可通过nums数组的部分整数相加得到。求加入整数个数的最小值。
    总结：贪心算法。假设miss是[1, n]中缺少的最小的数，则当前可组合的范围是[0, miss)。如果在数组中加入满足num <= miss的值，那么当前可组合范围是[0, miss + num)。为了最大化这个范围，我们应当加入miss值，使范围变成[0, 2*miss)，贪心处理此问题。若数组遍历当前值x在范围[0, miss)内时，则直接更新范围[0, miss + x)而不需要加入值，直到x > miss时再加入miss。
    错误：不会
+ [331. Verify Preorder Serialization of a Binary Tree](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/?tab=Description)
    题意：给定逗号分割的字符串，判断是否是二叉树的先序遍历,null用#表示
    总结：栈模拟。当栈顶为n,#,#时，将其替换成#，重复操作，先序遍历字符串的情况最终栈只剩一个#元素。注意当遇到n,#,#时要循环处理，直至栈顶不是n,#,#。
    错误：思路不清晰
+ [331. Verify Preorder Serialization of a Binary Tree](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/)
    题意：给定字符串（逗号分隔各值，null用#表示），判断其是否是某二叉树的先序遍历结果
    总结：（1）使用栈模拟，当遇到val,#,#的连续段时，将其替换成#。最终结果如果是#，即是。（2）使用入度出度。三类节点：根节点（入0出2）、叶子节点（入1出0）、其他节点（入1出2）。
+ [332. Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/)
    题意：给定一些飞机票的起点和终点，求一条用尽全部机票的路径，且路径的字典序最小。（起点JFK），题目保证一定有这样的路径。
    总结：（1）DFS + 有序邻接表。邻接表始终保持有序，贪心遍历所有可能的路径，一旦找到一条完整路径即可所求，直接停止搜索并返回。（2）图中欧拉路径存在的条件：全部点入度与出度相等（欧拉回路），或者只有1个点入度、出度相差1,1个点入度、出度相差-1，其他点入度和出度相等。题目已经保证了欧拉路径的存在。贪心DFS遍历，直至无路可走，当前点即为终点，向上回溯，再次无路可走即为次终点。注意在DFS过程中走过的边都在删除。
    错误：不会
+ [334. Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/)
    题意：给定整数序列，判断是否存在长度为3的子序列（不要求连续）满足递增。要求O(n)Time、O(1)Space。
    总结：（1）使用min和secondMin分别记录最小值和次小值，当大于这两个值时，返回真（2）O(n^2)解法。求每个数左边小于当前数的整数个数（求解f[i]，要遍历f[0...i-1]）。
    错误：不会
+ [337. House Robber III](https://leetcode.com/problems/house-robber-iii/)
    题意：小偷偷窃房间的金钱。全部房间呈二叉树排列，小偷只能从根节点进入进行偷窃，如果小偷偷窃了直接相连（父子节点）的两个房间会触发警报。求小偷不触发警报能够偷得金钱的最大值。
    总结：树型DP。每个节点有不偷和偷两种状态。记f[root][0]、f[root][1]分别为不偷root和偷root时候的最大值。g[root]为全局最大值。则g[root] = max(f[root][0]，f[root][1])。不偷root时，f[root][0] = g[root.left] + g[root.right]；偷root时，下层不能偷，则f[root][1] = f[root.left][0] + f[root.left][1] + root.val。终止条件g[null] = f[null][0] = f[null][1] = 0。整体上是一种全局最优、局部最优的思路。局部最优是用于求解后续全局最优。与Leetcdoe 188、309思想有点类似哦。
+ [338. Counting Bits](https://leetcode.com/problems/counting-bits/)
    题意：给定非负整数n,求[0, n]范围所有数二进制表示中1的位数。要求只能遍历一次
    总结：规律性题目。f[n] = f[n >> 1] + n % 2
+ [340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/?tab=Description)
    题意：给定字符串和整数ｋ，求最多包含ｋ个字符的最长子串
    总结：滑动窗口
    错误：没有考虑ｋ= 0，字符串非空的情形（异常）
+ [341. Flatten Nested List Iterator](https://leetcode.com/problems/flatten-nested-list-iterator/?tab=Description)
    题意：实现嵌套列表的扁平化迭代器。
    总结：栈模拟。初始化时列表逆序入栈。hasNext()的判断条件是栈非空且栈顶是整数而不是列表，因为列表有可能为空（需循环找到此情况，找不到则hasNext()为false）。next()函数直接返回栈顶的整数即可。
+ [341. Flatten Nested List Iterator](https://leetcode.com/problems/flatten-nested-list-iterator/)
    题意：将嵌套数组结构扁平化返回其值。如[1,[4,[6]]] > [1,4,6]。
    总结：使用栈实现。因为遍历过程中，当前正在处理的是最紧迫的，对当前元素深入搜索，需要逆序暂存后续回溯时使用的元素。
    错误：在hashNext里将栈顶列表展开，如果在next里展开的话，当栈顶为空列表时，本来没有元素，但hasNext返回true；next里展开后为空，出栈操作会出现空指针异常。
+ [343. Integer Break](https://leetcode.com/problems/integer-break/)
    题意：将不小于2的正整数分割成若干正整数的和，求所有分割方式中这些正整数乘积的最大值。
    总结：（1）DP。dp[i] = max(max(dp[j], j) * max(dp[i - j], i - j),其中1 <= j <= i/2。（2）数学方法。当分割成自然底数e时成绩最大。因此就是分割成2或3，实际当i > 4时，尽可能分割成3，每减3，乘以3。
+ [345. Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/?tab=Description)
    题意：将输入字符串中元音字母逆序。
    总结：先转换成字符串数组处理，双指针i, j分别从首尾向中间各自找到一个元音字母，然后交换。注意元音字母包含大写的和小写的
    错误：没有考虑大小写，直接把原串转换成小写处理不行，否则最后返回都是小写。
+ [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/?tab=Description)
    题意：给定整数序列，求出现次数前k的值
    总结：（1）桶排序O(n),O(n)，空间换时间。统计元素出现次数，桶排序，然后从后先前选出前k。（2）堆排序，O(nlogk)，O(n + k)。统计元素出现次数，使用容量为k的堆选出前k个元素。
    错误：不会
+ [351. Android Unlock Patterns](https://leetcode.com/problems/android-unlock-patterns/?tab=Description)
    题意：安卓9宫格图案锁，给定锁路径上键的最少个数m和最大个数n，求全部的路径个数。
    总结：DFS。1,3,7,9或2,4,6,8是对称的，所以只计算一种情况然后乘4，则总个数是 4 * f(1) + 4 * f(2) + f(5)。使用skip[10][10]记录哪些键之间是不可达的，其值为中间跳跃过的键，如skip[1][7] = 4。当4被访问过之后，1和7就可达了。然后深度优先搜索即可。
    错误：不会，注意m = 0或n = 0的情况。
+ [352. Data Stream as Disjoint Intervals](https://leetcode.com/problems/data-stream-as-disjoint-intervals/)
    题意：给定无序整数流，不断返回当前全部区间，要求区间不重叠。
    总结：使用TreeMap存储当前区间，对于加入的整数x，分情况讨论是插入区间还是合并区间。
    错误：情况分类不清晰
+ [354. Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/)
    题意：给定若干信封的长、宽，对于信封1和信封2，若w1 < w2 且l1 < l2，则信封1可转入信封2中。求所有信封中最多可以多少个信封套装在一起。
    总结：最长递增子序列的二维情况。不同的是信封的顺序任意。先按信封的长度升序排序，若长度相等，则按宽度降序排序。然后对排序后的数组，对宽度求最长公共子序列即可。宽度降序排列说明：[3,4]不能装[3,3]，因此排序需要把[3,4]放到[3,3]前面，否则按宽度求最长递增子序列时会出现[3,3]，[3,4]。
    错误：O(n^2)解法超时。二维的二分法查找存在问题，二维的判断存在很多不能比较的大小情况。
+ [356. Line Reflection](https://leetcode.com/problems/line-reflection/?tab=Description)
    题意：给定二维坐标系内若干点的左边，判断是否存在一条平行于y轴的直线使所有点关于该点对称。重叠点算一个点。
    总结：找出x坐标的最大值max和最小值min，如果存在对称轴的话，对称轴的x坐标值一定为(min + max) / 2。使用HashSet<String>存储所有点的hash值，利用TwoSum的思想判断所有点是否存在一个点关于对称轴对称。
    错误：点重复问题，点重复但左右两边重复点个数不等。
+ [357. Count Numbers with Unique Digits](https://leetcode.com/problems/count-numbers-with-unique-digits/)
    题意：给定非负数n，求[0, 10^n)范围内各位都不同的整数个数
    总结：动态规划。f(n) = f(n - 1) + 9 * A(9, n - 1)。
+ [359. Logger Rate Limiter](https://leetcode.com/problems/logger-rate-limiter/?tab=Description)
    题意：实现日志频率限制系统，每条日志信息对应一个时间戳，只有10秒中内未打印的日志才进行的打印。实现函数判断日志是否需要打印，当需要打印的时候需要打印，但代码里不需实现打印。
    总结：使用map记录消息最后一次打印的时间戳。只有当10秒内已经打印过直接false，否则更新map返回true
    错误：返回true的时候没有更新map，逻辑混乱。
+ [360. Sort Transformed Array](https://leetcode.com/problems/sort-transformed-array/?tab=Description)
    题意：给定数组nums，和ax^2 + bx + c的系数a,b,c,求依次带入公式后的结果值数组，要求结果升序，且时间复杂度为O(n
    总结：判断a = 0和a != 0的情况。a = 0顺序计算，根据b的正负决定结果的插入位置；当a != 0时，从两端向中间逼近，选择距离对称轴最远的位置计算，根据a的正负号决定结果的插入位置。
+ [361. Bomb Enemy](https://leetcode.com/problems/bomb-enemy/?tab=Description)
    题意：二维矩阵，存在墙、敌人、空地，在空地放置炸弹能炸死同行同列的敌人，但遇到越过墙停止扩散，求一颗炸弹最多炸死多少敌人。
    总结：（1）基本做法是预处理，对每个空位求left + top + bottom + right的和，更新最大值。（2）实际上两墙之间或墙和边界之间某条线上能炸死的敌人数量是固定的，因此可以用rowHits记录当前位置行可以炸死的敌人，只有在j == 0或grid[i][j - 1]为墙是才计算；用colHits[n]数组记录各列当前可炸死敌人数,只有i == 0或grid[i - 1][j]才更新。rowHits + colHits[j]即为当前位置可炸死的敌人。
    错误：只会基本做法。
+ [362. Design Hit Counter](https://leetcode.com/problems/design-hit-counter/?tab=Description)
    题意：设计HitCounter类，提供hit(int timestamp)方法进行hit，提供getHits(int timestamp)返回300秒内的hit的次数。假设方法调用传入的timestamp参数在调用过程中非递减。
    总结：（1）使用队列实现即可。每次hit()时更新队列尾元素或添加到队列尾，每次getHits()时删除过期的队列头（2）BST，但不好。
+ [363. Max Sum of Rectangle No Larger Than K](https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/)
    题意：给定二维矩阵，求满足不超过k的子矩阵和的最大值
    总结：这是不超过k的子数组最大值问题的扩展。主要思想是将各种多行矩阵压缩成单行数组，然后问题转换成不超过k的子数组最大值问题。不超过k的子数组最大值使用TreeSet存储s[i] = nums[0:i]子段和，对于当前s[j]，利用O(logn)可以查找出满足s[j] - s[i] <= k的s[i]的最小值。
    错误：不会
+ [365. Water and Jug Problem](https://leetcode.com/problems/water-and-jug-problem/)
    题意：有容积为x,y的两个水杯，求能不能倒出体积为z的水。
    总结：数学定理。当z是x和y最大公约数的倍数时，是可行的。注意特殊情况，z == x，z == y或z == x + y。
    错误：不会
+ [367. Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)
    题意：判断一个数是否是平方数
    总结：二分法
    错误：乘法溢出！！！！
+ [368. Largest Divisible Subset](https://leetcode.com/problems/largest-divisible-subset/?tab=Description)
    题意：给定数组，求最大集合，使集合中任意两元素a,b满足 a % b == 0 或 b % a == 0
    总结：动态规划。先排序数组，dp[i]表示以dp[i]结尾的子集合的最大值，则对于j < i 且dp[i] % dp[j] == 0，dp[i] = max(dp[j] + 1)，为了构造出最大集合，需用prev[i]表示dp[i]是由哪个得到的，同时用max记录最大集合对应的下标。最后根据max，prev数组构造最大集合
    错误：不会
+ [368. Largest Divisible Subset](https://leetcode.com/problems/largest-divisible-subset/)
    题意：给定整数集合nums，求最大子集，使得对子集内任意两个数a,b满足a % b = 0或b % a = 0。
    总结：动态规划。集合内整数从小到大排列后，满足后一个数是前一个数的倍数。先对原序列nums排序，从左向右，依次求当前包含nums[i]的子集最大值dp[i]，dp[i]的求解需要遍历[0, i - 1]中所有数，求dp[i]的最大值（dp[i] = max(dp[j]) + 1，其中j为满足nums[i] % nums[j] = 0的所有j），同时求解dp[i]最大值过程中，使用prev[i]记录下使dp[i]去最大值时对应的j（prev[i] = j），用于后续构建最大子集时从后向前进行构建。求解各dp[i]时用全局变量max记录下dp数组最大值对应的索引。dp求解完成后，从max开始向左沿着prev构建集合即可。
    错误：不会
+ [370. Range Addition](https://leetcode.com/problems/range-addition/#/description)
    题意：给定全为0的数组长度len，和若干三元组操作(l, r, x)，表示把区间[l, r]内的元素的值增加x。求全部操作完后的数组
    总结：O(n + k)。核心思想是只修改nums[l]和nums[r + 1]，nums数组存储的前后元素的相对大小。对于(l, r, x)操作，只需nums[l] += x， nums[r + 1] -= x（注意当r + 1越界时不做此操作）。最后求数组时，从0开始累加即可得到各位置的值。（类似有点像建筑轮廓那题，只需要记录下轮廓高度变化的点，即可得到轮廓的全貌）
    错误：不会
+ [371. Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/)
    题意：求两个数的和，不能用+和-
    总结：位运算。f(a, b) = f((a ^ b), (a & b) << 1)。
    错误：按位处理有问题
+ [373. Find K Pairs with Smallest Sums](https://discuss.leetcode.com/category/491/find-k-pairs-with-smallest-sums)
    题意：给定非递减整数序列nums1和num2，求全部数字对中和较小的前k个，其中数字对要求一个来自nums1，另一个来自nums2。
    总结：（1）基础解法O(k^2logk)。将nums1的前k个值和nums2的前k个值笛卡尔乘积，放入最小堆，取出前k个。（2）O(klogk)解法。将nums2[0]和nums1[0...n-1]分别加入最小堆（堆元素为int[3] {n1, n2, index2}），同时记录下每一对值中来自nums2那个数在nums2中索引（即index2）。从堆中取一个对{n1, n2, index2}，将入结果的同时，若index2 + 1小于nums2.length，则将{n1, nums2{index2 + 1}, index2 + 1}加入堆中（实际上堆中的对恰好包含了nums1中的所有元素，以及nums1[i]在nums[2]对应元素的最小值，除非nums1[i]与nums2中所有元素都配对过了，就不再加入堆了）。然后重复此过程。注意当nums1.length、nums2.length和k有一个为0时，直接返回空列表。
    错误：没有考虑数组长度为0或k为0的边界条件
+ [375. Guess Number Higher or Lower II](https://leetcode.com/problems/guess-number-higher-or-lower-ii/)
    题意：给定n，并已选择区间[1, n]中的一个数x。猜这个数的值，当猜错时，会反馈x与当前猜测值的大小关系，且当猜测为y时，若猜错，会损失y美元，猜对不损失。求需要有多少钱能够保证可以赢。
    总结：动态规划。保证可以赢就是无论目标值x是多少，采用某种猜测方式猜中时所损失的金钱一定不大于所求值。就是求每一种猜测方式最坏情况下的损失值（最大），并找出这些最大值中的最小值即为所求。（极小化极大算法：所有失败的最大可能中的最小值）
    错误：不会
+ [375. Guess Number Higher or Lower II](https://leetcode.com/problems/guess-number-higher-or-lower-ii/)
    题意：给定n，并已选择区间[1, n]中的一个数x。猜这个数的值，当猜错时，会反馈x与当前猜测值的大小关系，且当猜测为y时，若猜错，会损失y美元，猜对不损失。求需要有多少钱能够保证可以赢。
    总结：保证可以赢就是无论目标值x是多少，采用某种猜测方式猜中时所损失的金钱一定不大于所求值。就是求每一种猜测方式最坏情况下的损失值（最大），并找出这些最大值中的最小值即为所求。（极小化极大算法：所有失败的最大可能中的最小值）
    错误：不会
+ [376. Wiggle Subsequence](https://leetcode.com/problems/wiggle-subsequence/)
    题意：给定整数序列，求摆动子序列（不要求子序列连续）长度的最大值。
    总结：实际上是把序列中连续非升序或非降序的连续片段压缩成一个数，求最终序列的长度。或者可以立即为序列中前后两个数大小关系变为相反的情况的总次数，再加1（画出2维折线图）。（1）使用栈模拟，O(n)/O(n)。遍历序列，若当前元素不能增长摆动序列的长度时，此时栈顶出栈，当前元素入栈；否则直接入栈，最终返回栈大小即可（2）动态规划，O(n^2),O(n)。`dp[i][0] = max{dp[j][1]} + 1,当 nums[i] > nums[j]`；
`dp[i][1] = max{dp[j][0]} + 1,当 nums[i] < nums[j]`。（3）初始化f,d均为1，分别表示当前前后元素大小关系为大于和小于的情况。遍历过程中，当出现对应大小关系时，修改f,d的值。f = d + 1; d = f + 1。
+ [376. Wiggle Subsequence](https://leetcode.com/problems/wiggle-subsequence/)
    题意：给定整数序列，求摆动子序列（不要求子序列连续）长度的最大值。
    总结：实际上是把序列中连续非升序或非降序的连续片段压缩成一个数，求最终序列的长度。或者可以立即为序列中前后两个数大小关系变为相反的情况的总次数，再加1（画出2维折线图）。（1）使用栈模拟，O(n)/O(n)。遍历序列，若当前元素不能增长摆动序列的长度时，此时栈顶出栈，当前元素入栈；否则直接入栈，最终返回栈大小即可（2）动态规划，O(n^2),O(n)。`dp[i][0] = max{dp[j][1]} + 1,当 nums[i] > nums[j]`；
`dp[i][1] = max{dp[j][0]} + 1,当 nums[i] < nums[j]`。（3）初始化f,d均为1，分别表示当前前后元素大小关系为大于和小于的情况。遍历过程中，当出现对应大小关系时，修改f,d的值。f = d + 1; d = f + 1。
+ [377. Combination Sum IV](https://leetcode.com/problems/combination-sum-iv/)
    题意：给定整数序列nums和目标值target，从序列中选出若干数字，使其总和等于target。序列中每个数字可以选无数次，被选出的数字排列有顺序的区分。求这种序列的总数。
    总结：动规。（1）自底向上，迭代。（2）自顶向下。使用map做记录，避免重复计算。
    错误：自顶向下用数组做记录时，数组默认值是0，而某些值对应的序列总数也是0，导致冲突，每次求解时序列总数为0的情况都以为是默认值，然后继续求解。导致超时。
+ [378. Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)
    题意：给定n×n二维矩阵matrix，行和列都是非递减的，求矩阵中第k小的数
    总结：（1）最小堆，O(klogk)，多路归并。把矩阵看成m个横向的一维非递减数组，先将各数组首元素及其行列值（int[3]{val, i, j}）加入堆中，并自定义比较器。每次从堆中取出一个元素x后，若该元素x对应的行数组（matrix[i]）还有后续元素（j + 1 < n），则将元素加入堆。重复此过程。（2）二分法。以矩阵中的最小值（左上角）和最大值（右下角）确定的区间作为搜索空间。统计每行中小于mid值的个数。然后调整区间。注意Arrays.binarySearch在有重复元素的数组返回第一次搜索得到的值。2016年学校ACM竞赛打气球的题目就是用的基于值的二分（不是基于索引的二分）
+ [378. Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)
    题意：给定n×n二维矩阵matrix，行和列都是非递减的，求矩阵中第k小的数
    总结：（1）最小堆，O(klogk)，多路归并。把矩阵看成m个横向的一维非递减数组，先将各数组首元素及其行列值（int[3]{val, i, j}）加入堆中，并自定义比较器。每次从堆中取出一个元素x后，若该元素x对应的行数组（matrix[i]）还有后续元素（j + 1 < n），则将元素加入堆。重复此过程。（2）二分法。以矩阵中的最小值（左上角）和最大值（右下角）确定的区间作为搜索空间。统计每行中小于mid值的个数。然后调整区间。注意Arrays.binarySearch在有重复元素的数组返回第一次搜索得到的值。2016年学校ACM竞赛打气球的题目就是用的基于值的二分（不是基于索引的二分）
+ [379. Design Phone Directory](https://leetcode.com/problems/design-phone-directory/#/description)
    题意：实现手机号码资源管理类，支持get()申请占用一个可用号码,check(int)检查号码是否可用，release(int)释放号码
    总结：使用队列存放可用号码，使用set存放不可用号码（O(1)时间内判断是否可用）。注意若也用set存储可用号码会超时，大概是set的contains、add、remove操作虽然算O(1)，但执行的代码量要比使用队列多。
+ [380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/#/description)
    题意：实现集合类，支持O(1)时间复杂度的insert、remove、getRandom方法，其中insert当元素不存在集合中时插入，remove当元素存在集合中时删除，getRandom要求等概率的返回任一元素。
    总结：HashMap + ArrayList，其中HashMap存储元素及其对应的索引。ArrayList存储元素的值。当删除元素时，若是ArrayList尾元素，则直接删除其对应的HashMap和ArrayList即可，若不是尾元素，则用ArrayList的尾元素last去替换该元素的值，同时删除尾元素，并更新尾元素在map的下标。
    错误：当删除的元素不是尾元素时，忘记更新尾元素对应的map
+ [382. Linked List Random Node](https://leetcode.com/problems/linked-list-random-node/)
    题意：给定链表，实现数据结构，包含方法getRandom方法，用于等概率随机返回某个节点的值
    总结：蓄水池算法。假设已经读取n个数，现在保留的数是Ax，取到Ax的概率为(1/i)。对于第n+1个数A[i+1]，以1/(i+1)的概率取A[i+1]，否则仍然取Ax。设变量result为随机产生的节点值，节点依次编号1...n，遍历链表，使用random.nextInt(i)产生随机数x（其中i为节点编号），当x = 0时，用当前节点值更新result。遍历结束后返回result即可。当随机返回的时节点i的值时，对应概率为1/i * i/(i+1) * ... * (n-1)/n = 1/n。
+ [384. Shuffle an Array](https://leetcode.com/problems/shuffle-an-array/)
    题意：洗牌算法，对数组实现洗牌
    总计：采用`Collections.shuffle()`方法的策略，逆序遍历列表list，对于元素list[i]，从list[0...i]中随机选择一个元素list[j]并与list[i]交换（其中0 <= j <= i），重复此操作直至列表第二个元素。
+ [385. Mini Parser](https://leetcode.com/problems/mini-parser/)
    题意：将嵌套数组字符串解析成对象
    总结：（1）递归。终止条件，字符串为单个数字；递推：按最外层逗号分割数组（通过用count维持开、关括号的差值，差值为0时表示最外层），递归调用处理每个字段。（2）迭代方法。栈顶元素始终是当前正在处理的最小范围的数组。遇到关括号出栈。
+ [386. Lexicographical Numbers](https://leetcode.com/problems/lexicographical-numbers/)
    题意：给定正整数n，返回[1, n]区间内整数的字典序排列
    总结：（1）递归。字典序对应于一颗树。先序遍历即可，终止条件为当前值大于n。（2）迭代。一直乘10直到超过n，此时依次加1,2,3...9，到9后再一直除10直到末尾数非9，此时加1，再重复上述过程。
+ [388. Longest Absolute File Path](https://leetcode.com/problems/longest-absolute-file-path/?tab=Description)
    题意：给定树型目录，求最长的绝对文件路径
    总结：栈模拟。栈中元素的个数即为嵌套深度。字符串的长度需要加上斜杠/，即栈内元素个数（减１）。
    错误：未加斜杠，嵌套深度用单独的变量表示
+ [388. Longest Absolute File Path](https://leetcode.com/problems/longest-absolute-file-path/)
    题意：给定目录结构，求最深文件的路径长度
    总结：使用栈，按\n字符分割字符串，对于每个子串，根据\t个数（String.lastIndexOf('\t') + 1）和栈内元素个数判断当前元素深度关系，选择出栈还是入栈。注意输入字符串中的\n是一个字符。而字符串中的\\n是两个字符。
+ [390. Elimination Game](https://leetcode.com/problems/elimination-game/)
    题意：给定1,2...n的一序列，先从第一个开始，每2个删除1个元素，得到新序列，再从新序列最后一个开始，从右向左每2个删除1个元素。重复此过程，直至只剩下一个元素。求最后剩下的元素。
    总结：（1）始终记录每次操作的第一个元素、元素贪心。（2）分治。从左到右处理后，实际上是把奇数去掉了，只剩偶数。将新序列除以2，新序列转换成了1,2...n/2。此次的方向与上次相反，将序列逆序，通过映射可发现，两不同方向问题对应位置的元素和是定值1 + n / 2。因此递推是为f(1) = 1，f(n) = 2 * (1 + n / 2 - f(n / 2)
    错误：思路不清
+ [391. Perfect Rectangle](https://leetcode.com/problems/perfect-rectangle/#/description)
    题意：给定若干矩形左下角和右上角点的坐标，判断这些矩形是否恰好拼成一个矩形。
    总结：能拼成矩形的充分条件是：记所有小矩形的四个最外层边界left, right, top, bottom。（1）这个边界确定的矩形的面积等于各小矩形面积之和（2）小矩形的定点恰好只有4个出现了一次，其他都出现了偶数次（3）只出现1次的4个顶点恰好是left, right, top, bottom确定的4个点。
    错误：没有考虑到条件（3），导致[[0,0,1,1],[0,0,2,1],[1,0,2,1],[0,2,2,3]]测试用例结果错误。
+ [391. Perfect Rectangle](https://leetcode.com/problems/perfect-rectangle/)
    题意：给定一系列矩形的左下角和右上角坐标，判断这些矩形是否能恰好拼成矩形且无覆盖。
    总结：重要条件：除4个边角的点只出现一次，其他点均出现偶数次；4个边角确定的矩形的面积与各矩形面积之和相等。判断偶数次可以使用集合，当在集合中存在时删除该点；否则加入集合。最终集合中应该只剩下4个边角处的点，再判断面积是否相等。注意，集合中的对象若是自定义时，必须重写equals和hashCode方法，快捷的方法可以将点的坐标中间加空格拼接成字符串。
    错误：徘徊在边缘，思路不清
+ [392. Is Subsequence](https://leetcode.com/problems/is-subsequence/)
    题意：给定字符串s和t，s较短，t很长，判断s是否为t的子串（不要求连续）
    总结：贪心算法。用ix表示s下一个要匹配的位置，遍历t，当匹配成功时ix加1。当ix == t.length()时返回true。
    错误：遍历t退出循环时，有可能是t恰好最后一个字符匹配上s的最后一个字符。不能盲目返回false。
+ [393. UTF-8 Validation](https://leetcode.com/problems/utf-8-validation/?tab=Description)
    题意：判断给定整数数组是否是合法的UTF-8编码
    总结：（1）递归方法。（2）迭代方法。二进制字面值 0b11001010，十六进制字面值0xCA，八进制字面值0312
+ [394. Decode String](https://leetcode.com/problems/decode-string/?tab=Description)
    题意：解码字符串，k[encoded_string]表示ｋ个encoded_string相连，原串存在嵌套结构，求解码后的字符串
    总结：栈模拟。最初在栈内预置一个 StringBuffer表示整个结果，用一个整数栈存放次数，遇到整数时一直循环读到非整数；遇到[时入栈一个StringBuffer，遇到]时出栈整数和StringBuffer，将拼接结果append到栈顶的StringBuffer；遇到字符串时直接加入到栈顶的StringBuffer。最终栈内只剩下预置的StringBuffer，返回其值即可
    错误：循环读取整数时没有更新i
+ [394. Decode String](https://leetcode.com/problems/decode-string/)
    题意：解析嵌套规则字符串，k[<str>]表示连续k个<str>字符串。如3[a2[c]]转化成accaccacc。
    总结：使用栈。栈顶总是存储当前方括号内（不含方括号）的字符串。栈顶下一元素为该方括号重复的次数。每次一遇到数字，就直接往后读到非数字，不利用外层迭代，然后入栈数字；遇到[，入栈空串表示当前方括号内容；遇到]出栈2个元素，然后将重复结果合并到栈顶。遇到字母，直接合并到栈顶。
+ [395. Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/)
    题意：给定字符串s和整数k，求满足如下要求子串的最大长度：子串内包含的每个字符至少出现k次。
    总结：分治。统计s中各字符的个数，记录下其第一次出现的索引。求出现次数的字符。当次数小于k时，将原字符串按该字符第一次出现的位置分成两半，递归求解取最大值；否则直接返回当前字符串的长度。
+ [397. Integer Replacement](https://leetcode.com/problems/integer-replacement/)
    题意：给定整数n，可以进行两种操作：（1）如果n是偶数，n = n / 2。（2）如果n是奇数，n = n + 1或n = n - 1。求使n变为1的最小操作次数。
    总结：（1）有向图广度优先搜索，使用队列。（2）技巧性。当n为偶数时，n = n / 2。否则判断n - 1和n + 1两数二进制表示中哪个数为1的位数大小。当n - 1比n + 1的二进制为1的位数少时，n = n - 1。当n - 1的二进制为1的位数大于等于n + 1时，n = n + 1。不过当n = 3时是特例，2和4二进制为1的位数相等。但应该采取n = n - 1的策略。在判断n - 1和n + 1二进制为1的位数的大小时，实际上是在判断当减1或加1时对原二进制数n中1的位数的影响。由于n为奇数，故末位为1，只需判断倒数第2位是否为1即可，若倒数第2位为0，则加1不会影响1的位数，而减1一定会减少1的位数，所以此时采取n = n - 1，否则n = n + 1。
+ [398. Random Pick Index](https://leetcode.com/problems/random-pick-index/)
    题意：给定可能包含重复数字的序列，返回target值的下标，要求当target重复时，其每个下标被返回的概率相等
    总结：蓄水池算法。遍历数组，使用蓄水池算法在target的全部下标中随机返回一个。
+ [399. Evaluate Division](https://leetcode.com/problems/evaluate-division/)
    题意：给定若干A / B = K结构的等式，求未知除法算式的值。如果给定 a / b = 2.0, b / c = 3.0。求a / c 或 c / a。
    总结：边带权值的有向图的遍历。根据已知等式构建有向图，用邻接矩阵表示，由于给定的等式操作数都是字符串，因此邻接矩阵可以用HashMap<String, HashMap<String, Double>> adj表示。当处理 a / b = 2.0时，需要同时将a > b的边和b > a的边加入图中。构建出有向图后，对图进行深度优先遍历，已遍历过的边需要标记已遍历，可将其边的权值设置为0.0，遍历过后在恢复。注意若在标记已遍历后、且在恢复边权值之间搜索到解返回前，一定要先恢复边的权值，否则会影响其他遍历。浮点数相等的判断：两值之差小于1e-6。
    错误：HashMap遍历过程中删除元素，导致concurrentModify异常；若在标记已遍历后、且在恢复边权值之间搜索到解返回前，未先恢复边的权值
+ [400. Nth Digit](https://leetcode.com/problems/nth-digit/#/description)
    题意：求1,2,3,4,5,6,7,8,9,10,11,12,13...组成的序列中第n个单数字的值。
    总结：迭代过程中计算出各位数有多少位x，然后n减去x，直至找到所求数所在数字是几位数。然后求出第n个单数字所在的整数的值，进而求出这个单数字。
    错误：乘法溢出。思路不清
+ [401. Binary Watch](https://leetcode.com/problems/binary-watch/)
    题意：二进制手表，小时用4个灯表示4位二进制数（0-11），分钟用6个灯表示6位二进制数，（0-59）。给定亮灯的个数n，求可能的时间。
    总结：双层循环分别遍历h:0-11和m:0-59。统计(h << 6) + m的二进制数中1的位数（Integer.bitCount()），若等于n则加入结果。
+ [402. Remove K Digits](https://leetcode.com/problems/remove-k-digits/)
    题意：给定数字串num和整数k，求删除k数字后得到的子串数值的最小值。
    总结：贪心。（1）单调栈，O(n + k)解法。栈内自底向上大致呈非递减，当元素个数不足以得到结果时，直接压栈即可（2）O(n^2)解法。不从删除k个数字的角度，而是从剩余数字的角度求解。共剩余m = num.length() - k个数字。从高位起遍历依次求解每个数字。该数字就是可选区间内选择数值最小的数字。可选区间的范围满足区间左边界的前一个数字已经被选择了，右边界后面的剩余数字和正在求解的当前数字、已经得到的数组足以凑齐m位。每求得一位后，向右滑动区间。
    错误：单调栈方法中，栈内元素个数可能多余所需个数，取从栈底开始的前n-k个即可；去掉结果的前导0；num长度等于k时，需返回"0"
+ [403. Frog Jump](https://leetcode.com/problems/frog-jump/)
    题意：青蛙过河，河按单位进行了划分。给定了一系列按递增顺序排列的石头的位置。初始时青蛙在第一块石头上，且第一次跳跃的距离为1。对后续的跳跃距离，若上次跳跃距离为k，则此次跳跃可以跳k - 1, k, k + 1。求青蛙能否从第一块石头开始，不掉进水里，到达最后一块石头
    总结：（1）深搜 + 记忆表。携带当前位置和上一次跳跃距离进行深搜，并用二维表记录下搜索失败的情况。（2）从小到大遍历石头，迭代求解在每个石头上可以跳跃的距离。当遇到结尾处的石头时直接返回true。
    错误：深搜时没有使用记忆表，超时。
+ [404. Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/)
    题意：计算二叉树所有左叶子节点值的和
    总结：递归求解。从叶子节点的上一层进行判断是否是左叶子节点。是的话，终止左子树，否则递归左子树。右子树递归。
+ [405. Convert a Number to Hexadecimal](https://leetcode.com/problems/convert-a-number-to-hexadecimal/)
    题意：将整数的二进制补码转换成十六进制
    总结：每次处理最低4位，使用逻辑右移 >>>首位补0，右移4位。直至为0
    错误：未考虑边界条件0，但为0是不进入循环，应直接返回0
+ [406. Queue Reconstruction by Height](https://leetcode.com/problems/queue-reconstruction-by-height/?tab=Description)
    题意：多个人站一排，现有数组包含若干数对（h, k），h为身高，k为队列中此人前面身高大于等于h的人的个数。对数组重排。
    总结：贪心。（1）按身高降序排列，身高相同的按k升序排列。将排序后的元素顺序插入新队列，已插入新队列的元素身高满足大于等于待插入的元素的身高。因此将当前元素p[]直接插入到新队列中下标为p[1]的位置即可。（2）按k升序排列，k相等的按h升序排列。依次插入新队列，插入到新队列中满足count <= p[1]的最后一个位置。
    错误：使用后一思路，复杂
+ [407. Trapping Rain Water II](https://leetcode.com/problems/trapping-rain-water-ii/#/description)
    题意：给定二维矩阵，元素值代表高度，求最大积水量。
    总结：优先级队列 + BFS。将4个边界上的位置加入优先级队列，每次取出高度最小的元素curr，对于其四周的元素next，若非法位置或访问过则忽略。否则，若next高度小于curr，则积水量加上两者高度的差值（因此curr是最小）。然后把next加入队列，其高度为curr和next高度中的较大值，即若next的高度小于curr，则将next的高度替换为curr的高度。循环处理直至优先级队列为空。
    错误：不会。
+ [408. Valid Word Abbreviation](https://leetcode.com/problems/valid-word-abbreviation/#/description)
    题意：判断字符串word的缩写abbr是否合法。
    总结：两个指针i,j依次对比。遇到数字，就while把数字读取完，然后i跳过数字的长度继续比较。需要注意缩写中的数字不可能出现前导零，若出现则直接返回false。同时还要判断i,j越界的问题
    错误：没有考虑到前导零的问题
+ [411. Minimum Unique Word Abbreviation](https://leetcode.com/problems/minimum-unique-word-abbreviation/description/)
    题意：给定字符串target和字典，求target的最短缩写abbr，使得字典中没有单词的缩写是abbr。
    总结：回溯。回溯构造target的所有缩写，对于构造的每个缩写a，遍历字典中所有单词判断是否有单词缩写也是a，取没有冲突的缩写中最短的缩写。作为优化，可以从字典中删选出长度与target相同的单词。
    错误：不会
+ [413. Arithmetic Slices](https://leetcode.com/problems/arithmetic-slices/)
    题意：给定整数序列，求是等差数列（长度至少为3）的连续子序列的个数。
    总结：（1）动态规划。计算以每个nums[i]结尾的等差数列的个数，然后求和。（2）长度为n + 2的等差数列包含n个长度为3的子等差数列。那么f(n) = f(n - 1) + n。所求解的问题是所有f(n)的和。f(n)的求解也可以使用分治 + 记忆表。
+ [416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
    题意：给定整数序列，判断是否能分成总和相等的两组
    总结：01背包问题。先判断总和是否是偶数，不是的话直接返回false。若是偶数，则问题转化成容量为sum / 2，各整数价值和重量均为自身值的01背包问题。判断最大容量是否能达到 sum / 2即可。dp数组只用一维即可。实际上我们只关心是否能装满，而不关心最大价值，因此问题还可以简化成是否能装满，dp数组使用一维布尔数组。
    错误：回溯法存在大量重复计算问题。
+ [417. Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/?tab=Description)
    题意：给定二维矩阵陆地，元素值为陆地高度，矩阵左侧和上侧是太平洋，右侧和下侧是大西洋，陆地上的水只能下高度相等或高度较低的地方流，求水能够同时流入太平洋和大西洋的陆地的坐标。
    总结：DFS。分别从大洋边沿非递减的高度进行标记，visited整数数组的低位1表示能流入太平洋，次低位1表示能流入大西洋，则visited[i][j] == 3的坐标(i, j)即为所求。visited数组向上回溯时不恢复状态。
    错误：当一个元素时，需要同时从太平洋和大西洋进行DFS，因此不是if-else关系
+ [417. Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)
    题意：给定矩形陆地各位置高度，左侧和上侧连接太平洋，右侧和下侧连接大西洋，求陆地上那些位置的水可以同时流入两个海洋。水可以向高度相等或更低的地方流动。
    总结：图遍历（1）深度优先遍历。用二维数组visited记录是否遍历，从左侧上侧开始遍历，沿着高度相等或更高的地方搜索，遍历过的位置或1（visited[x][y] |= 1），从右侧下侧开始的遍历同理，但遍历过的位置标记或2。遍历过程中，若visit[x][y] == 3，说明同时被遍历，加入结果列表（2）广度优先遍历。
+ [418. Sentence Screen Fitting](https://leetcode.com/problems/sentence-screen-fitting/?tab=Description)
    题意：给定数组表示句子，一块r x c的屏幕，屏幕内最多显示几遍完整的句子。句子中相邻单词间必须间隔一个空格或换行符。
    总结：先将句子用空格分隔拼接成字符串s，start表示当前下标，每次start += c（列宽），当此时start为空格时，由于此处是换行，则直接start++即可。否则start--一直回退到空格的后一位置。最后返回start / s.length()
    错误：r x c的时间复杂度超时
+ [419. Battleships in a Board](https://leetcode.com/problems/battleships-in-a-board/)
    题意：给定二维矩阵甲板，甲板上战舰覆盖的位置用X表示，空隙用.表示。规定战舰只能是一排或一列，且战舰间一定有缝隙。要求遍历一遍，O(1)空间，不能修改二维矩阵，求出战舰数量。
    总结：只在战舰最左上角的时候count加1。左上角的判断：字符为X && (左边是边界 || 左边是.) && (上边是边界 || 上边是.)
+ [421. Maximum XOR of Two Numbers in an Array](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/#/description)
    题意：给定整数数组，求数组任意两个数异或结果的最大值。
    总结：从高位向低位，高位的1对数值的大小起了决定性作用。（1）位运算（2）Trie树，树根为高位。
    错误：不会
+ [422. Valid Word Square](https://leetcode.com/problems/valid-word-square/?tab=Description)
    题意：给定n个字符串每行一串排列，判断构成的图形是否沿主对角线对称。
    总结：for i: 0-> n {for j: 0->w[i].length()}两层循环判断，注意字符串不定长导致的溢出问题。
    错误：边界问题
+ [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)
    题意：给定大写字符串，对任意位置的字母进行任意替换，最多替换k次，求替换后连续重复子串的最大长度。
    总结：贪心 + 滑动窗口。维护一个滑动窗口，统计窗口内出现次数最多的字符的次数，维护窗口的长度使得窗口长度减去字符出现的最大次数（即需要替换的次数）的值不超过k。实际上在长度允许的情况下，当然是替换k次的长度一定大于替换次数小于k时的长度。由于每个字符的出现次数都是一步一步增加的，所以在迭代过程中，直接max(a,b)函数就能得到最大值。题目中不关心出现次数最多的字符是哪个字符，只关心次数。
    错误：题意理解错了，以为每个字符都可以k次。
+ [425. Word Squares](https://leetcode.com/problems/word-squares/#/description)
    题意：给定若干长度相等的字符串，按行排列其中的若干字符串使矩阵满足沿对角线对称的特性。求所有这样的排列。
    总结：回溯 + Trie树。提高回溯效率的方法是根据对称性利用Trie树前缀匹配获得下一步可能的后续字符串。Trie树的节点上存储的是以该节点开头的所有字符串，根节点存储的是全部的字符串。
    错误：没有想到根据对称性利用前缀匹配获取下一步的字符串。
+ [432. All O`one Data Structure](https://leetcode.com/problems/all-oone-data-structure/)
    题意：设计数据结构，支持根据键进行inc加1，dec减1，getMaxKey获取最大值的某一个键，getMinKey获取最小值的某一个键。
    总结：双向链表 + 哈希表，此题目与460 LFU思路类似。链表节点对应值，每个节点有个set存储该值对应的key，inc和dec操作实际上节点在链表上后移或前移。哈希表用于记录每个key存储在哪个节点上。小技巧：增加dummy，使用dummy.next存储双向链表首节点，dummy.prev存储双向链表尾节点，可以避免头结点和尾节点为空的判断。
+ [435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)
    题意：给定一系列区间，移除若干区间使得剩余区间不重叠。求移除区间数的最小值。
    总结：区间调度，贪心算法。反向思维，题目可以转换为从一系列区间内选择不重叠区间的最大数量。首先按结束值排序，每次选取与当前不重叠且结束值最小的区间，结果即为一种最优解。
    错误：不会
+ [436. Find Right Interval](https://leetcode.com/problems/find-right-interval/)
    题意：给定若干区间，对于每个区间interval，求区间起始值大于等于interval结束值的区间索引的最小值。
    总结：（1）TreeMap。遍历区间，使用TreeMap记录各区间对应索引。再次遍历区间，对于区间intervals[i]，调用TreeMap.ceilingEntry(intervals[i].end)方法即可得到目标索引（注意null判断）。（2）使用二维数组记录区间起始值和索引。排序 + 二分查找。
+ [437. Path Sum III](https://leetcode.com/problems/path-sum-iii/)
    题意：求二叉树中路径片段（仅满足连续即可）和为s的路径个数。
    总结：先序遍历，用路径片段上尾节点到根节点的路径和减去路径片段上头节点到根节点的路径和求路径片段和，类似于two sum的思路保存下上层每个节点到根节点的路径和。（[博客](https://www.deadend.me/2016/12/04/path-sum-iii/)）
    错误：不会
+ [445. Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/)
    题意：给定两个链表代表两个大整数（每个节点代表一位，最高位在链表首部），求两整数的和（用链表表示）。
    总结：先计算两者长度，然后递归处理，递归过程中较长链表向后迭代，较短链表不变，直至两链表等长再一起向后迭代。注意最终返回链表不能有前导0。
+ [446. Arithmetic Slices II - Subsequence](https://leetcode.com/problems/arithmetic-slices-ii-subsequence/)
    题意：给定整数序列，求子序列（不要求连续，长度至少为3）中等差数量的个数。
    总结：动态规划。对于每个元素，使用hashMap记录以该元素结尾的长度至少为2，差值为键的等差序列的个数，对于nums[j]元素，遍历[0, j-1]的所有元素，从map[j]中找出键为d = nums[i] - nums[j]的值，这个值就是以nums[i]为结尾且长度大于等于3的等差数列的个数c，将该值加入到全局变量里。然后将c + 1追加到map[i]键为d的值上，以供后续求解。其中c + 1中的1对应的是nums[j]、nums[i]序列（长度为2）。
    错误：不会
+ [450. Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/)
    题意：删除二叉搜索树中值为key的节点，并保持二叉搜索树的特性。
    总结：递归。被删除的节点分为三种情况处理
    + 左、右子树均为空：直接删除当前节点即可（返回null）
    + 左、右子树有一个为空：用左、右节点中非空的那个代替当前节点（返回左右节点中非空的节点）
    + 左、右子树均非空：在右子树找到最小的节点（从右节点开始一直靠左深搜），用最小节点的值覆盖当前节点，然后递归调用从右子树中删除最小节点。最小节点的删除也可以使用迭代的方法，用prev记录最小节点的父节点，prev.left = null即可，不过要注意prev = null的判断。
+ [453. Minimum Moves to Equal Array Elements](https://leetcode.com/problems/minimum-moves-to-equal-array-elements/)
    题意：给定n个非负整数，每次操作可以给其中n-1个数加1，执行若干次操作使得所有整数的值相等。求操作次数的最小值。
    总结：逆向思维。每次给n-1一个数加1等价于每次给1个数减1。因此最小操作对应于将所有数变为所有整数中的最小值，即对应次数为sum - n * min。
    错误：不会
+ [455. Assign Cookies](https://leetcode.com/problems/assign-cookies/)
    题意：有若干各种大小的饼干，分给若干个小孩，每个小孩有一个贪婪因子表明自己得到满足时最小的饼干大小，求分配后能够满意的小孩的最大值。
    总结：贪心。先对贪婪因子和饼干大小分别排序，遍历饼干，若当前小孩的贪婪因子小于等于当前饼干大小，切换到下一个小孩。
    错误：没有考虑房子位置和加热器位置存在重复的情况
+ [456. 132 Pattern](https://leetcode.com/problems/132-pattern/)
    题意：给定整数序列a，求是否存在i < j < k，使得 a[i] < a[k] < a[j]. 
    总结：栈 + 贪心（1）逆序处理。栈内始终存储大于当前值的元素，否则将小于当前元素的元素连续出栈（未必会直到栈空），用s3（对应于a[k]）记录连续出栈的最后的一个元素（出栈元素的最大值），而此时栈内有大于s3的元素，后面的遍历只需要找到小于s3的数即可说明存在这样的序列。可以看出，栈内元素从栈底到栈顶方向上是非递增顺序，栈的用途是缓存了后续可能作为s3的元素。能够成为s3的元素未必是栈内的栈底元素，因为连续出栈操作不一定会一直出栈到栈空。（2）正序处理，后面是否有元素落在当前最大区间范围内。栈内元素存储区间的最小值和最大值。起始时入栈元素是[a[0], a[0]]。比较复杂，分情况讨论当前元素与栈顶元素左边界和右边界的大小关系，然后觉得是更新栈顶、出栈还是入栈操作。
+ [460. LFU Cache](https://leetcode.com/problems/lfu-cache/)
    题意：实现缓存类，支持O(1)时间复杂度的get和put操作，当缓存满时，按照LFU（最少使用算法）剔除掉最少使用的键，若存在多个键，则剔除最旧的那个。
    总结：使用HashMap vmap存储键值対，使用双向链表从小到大存储使用次数，每个节点对应一个次数，节点内包含当前次数对应的所有键，另外使用一个HashMap nmap存储键与节点间的对应关系。由于在剔除时若多个键存在相同使用次数需要剔除最旧的键，因此每个节点内用LinkedHashSet有序的存储各键，每次剔除LinkedHashSet的第一个元素即可。注意当节点内的键为空时需要删除节点。双向链表操作时要注意是否是尾节点或首节点，避免空指针异常。
    错误：不会
+ [462. Minimum Moves to Equal Array Elements II](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/)
    题意：给定n个非负整数，每次操作可以给其中1个元素加1或减1，执行若干次操作使得所有整数的值相等。求操作次数的最小值。
    总结：求中位数。实际上是是求得一个数z，使得数组元素与z的距离的和最小。将所有数标记在数轴上，从左到右方向，对于第i个数与倒数第i个数到z的距离和，当z位于它们之间时才最小且值固定，因此当z为数组中位数时可以达到最小次数。利用快排的partition求中位数即可。
+ [463. Island Perimeter](https://leetcode.com/problems/island-perimeter/#/description)
    题意：给定0,1矩阵，0表示水，1表示陆地，矩阵四周被水包围，且其中只有一整块陆地。求陆地的边长。
    总结：（1）计算元素为1且邻接为1的次数，即接壤的次数l，同时统计为1的元素个数c，边长则为4 * c - l。（2）计算0,1接壤的次数x，则x / 2为边长。
+ [464. Can I Win](https://leetcode.com/problems/can-i-win/description/)
    题意：给定[1,n]n个整数和目标和total，两人分别从n个数中选择数字累加，累加和先到达n的选手赢。求第一个选手能否保证能赢。n不超过20.
    总结：记忆化dfs。使用整数used第i位表示使用了i。dfs函数的定义是对于当前total和used，是否存在一种选择i使得自己能赢（dfs(total, used) = true），即dfs(total-i, used | (1 << i)) == false
    错误：边界处理，当n数之和小于total时，直接返回false
+ [466. Count The Repetitions](https://leetcode.com/problems/count-the-repetitions/)
    题意：给定s1,n1,s2,n2，S1为n1个s1拼接得到，S2为n2个s2拼接得到。通过删除S1中部分字符，最多可以得到多少个S2
    总结：关键在于求解循环节。记录第一个字符匹配成功的位置，当再次在该字符位置匹配成功时表明正好经过了一次循环，则循环节即为两位置确定的字符串。然后直接跳过所有的循环达到s1*n1的最后位置继续匹配。
    错误：不会
+ [467. Unique Substrings in Wraparound String](https://leetcode.com/problems/unique-substrings-in-wraparound-string/)
    题意：给定无限长字符串s = "abc...xyzabc...xyza.."（无限重复），给定字符串p，求p中非重复的连续子串在s中出现的总次数
    总结：统计26个字母，在p中以每个字母结尾的连续子串的最大长度。最后求和即可。自动解决了覆盖和重复计算问题。
+ [471. Encode String with Shortest Length](https://leetcode.com/problems/encode-string-with-shortest-length/?tab=Description)
    题意：按照`k[encoded_string]`的规则编码字符串使其长度最小，求最小编码串。
    总结：记忆化动态规划。f(s) = min(g(s), min(f(s[0:k-1]) + f(s[k:n-1])))，其中f(s)为所求问题，g(s)为整个串直接编码成k[es]时的最小结果，后者是将s分成2半后各自最小编码相加后的最小结果，然后取最小值。由于有大量的重复子问题，因此用记忆化避免重复求解。
+ [472. Concatenated Words](https://leetcode.com/problems/concatenated-words/)
    题意：给定字符串集合，找出满足由集合内至少2个字符串能拼接得到的所有字符串，要求拼接得到的字符串必须在给定集合内。
    总结：对每个字符串选择各种位置进行分割，递归判断左右两半是否可拼接得到。需要缓存拼接成功和拼接失败的字符串用于加速判断。
    错误：只缓存拼接成功的字符串导致超时。
+ [473. Matchsticks to Square](https://leetcode.com/problems/matchsticks-to-square/)
    题意：给定正数数组，求是否能分成4组，使得每组的总和相等
    总结：NP问题，采用回溯（DFS）。对于给定数组，求子集和等于定值的问题，回溯时的整体思路是是否将当前元素加入集合。而对于该题分成4等份，整体思路是将当前元素加入哪一个集合。
+ [474. Ones and Zeroes](https://leetcode.com/problems/ones-and-zeroes/)
    题意：给定01字符串组成的数组、m和n，求用m个0和n个1可以构造出数组中字符串的最大个数。
    总结：01背包问题。只是约束条件中的重量变成了二维，价值全部变成了1。商品序号的维度可以压缩，空间复杂度达到O(mn)，但时间复杂度依然是O(kmn)。
+ [475. Heaters](https://leetcode.com/problems/heaters/)
    题意：给定若干房子和加热器的位置（一维），求使得所有房子被加热器加热范围覆盖时加热器最小的加热半径。
    总结：（1）对房子位置和加热器位置排序。遍历房子，对每个房子，通过判断与加热器heater[j]和heater[j + 1]的距离大小关系（当>=时要一直向后切换加热器），找到里当前房子最近的加热器。各房子与各自最近加热器的距离的最大值即为所求。（2）对加热器位置排序，针对每个房子利用二分法求最近房子的位置。
    错误：方法（1）中循环条件写>而非>=，导致当两个加热器在同一位置时不再向后切换，而此时加热器未必是最近的。
+ [477. Total Hamming Distance](https://leetcode.com/problems/total-hamming-distance/)
    题意：给定数组，求任意两个元素汉明距的总和
    总结：按位处理。统计每位为1的个数，该位产生的汉明距就是该位1的个数和0的个数的乘积。
+ [482. License Key Formatting](https://leetcode.com/problems/license-key-formatting/?tab=Description)
    题意：格式化字符串，逆序每Ｋ个字符用-分割
    总结：逆序遍历，count统计非-字符串的个数，当count == k时添加-，最后要判断首字符是否为-，再返回
    错误：只有-的字符串
+ [483. Smallest Good Base](https://leetcode.com/problems/smallest-good-base/)
    题意：给定十进制整数n，求最小的基数k，使得k >= 2且n的k进制表示各位全为1
    总结：n的n-1进制表示各位一定为1。根据n的范围可以确定二进制表示的最大长度l（当k = 2时），遍历l ~ 2，使用二分法判定是否存在某进制满足题意。
    错误：不会，最大长度l的确定和对进制二分时上限的判定很容易出错。
+ [484. Find Permutation](https://leetcode.com/problems/find-permutation/?tab=Description)
    题意：给定由D、I组成的字符串，D表示相邻两个数字递减，I表示相邻两个数字递增，设字符串长度为n，求找出[1, n + 1]组成的n + 1位的、满足字符串DI关系的、字典序最小的排列。
    总结：贪心算法。（1）O(n)。先创建{1, 2, ..., n + 1}的数组p，找到连续的D的起止位置s,e，然后把数组p中[s, e + 1]内的数字逆序即可（2）最坏O(n^2)。先创建{1, 2, ..., n + 1}的数组p，从左到右，若当前位置不满足D或I关系，则交换两个数，此交换可能导致前面已经排好的数字打破DI关系，向前检查直到关系正确。
+ [485. Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/#/description)
    题意：给定整数数组，求连续1的最大长度
    总结：遇到1时count++，否则count = 0。每次循环都用count更新max。不能只在nums[i]非1时更新，否则可能数组终止不能触发更新出现问题。
+ [486. Predict the Winner](https://leetcode.com/problems/predict-the-winner/)
    题意：给定整数序列，两个选手依次从整数序列的首部或尾部取走一个整数，最终取走整数之和较大者为赢家。两选手都采取最优的方案使其整数和最大化，判断选手1能否胜出。
    思路：动态规划。自底向上和自顶向下均可。（1）求各区间nums[i:j]内先者与后者整数和之差（2）求各区间nums[i:j]内先者能得到分数的最大值。dp[i][j] = max(subsum - dp[i+1][j], subsum - dp[i][j-1])。
    错误：第一思路是利用回溯求解，没有注意到重叠子问题。
+ [487. Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii/#/description)
    题意：给定0,1数组，允许最多一次翻转将0变成1，求连续1的最大长度。
    总结：（1）维护窗口[l, r)使其最多包含k个0。（2）将元素中连续的1压缩得到数组c，遍历c，当遇到0时，将其前、后元素相加再加1即可此时长度l，再用l更新max（3）当出现3个0时，第1个0和第3个0之间的元素长度即连续1的长度，假设数组首尾各有1个0，使用循环数组存储0的下标。需注意原数组中没有0的情况。
+ [490. The Maze](https://leetcode.com/problems/the-maze/?tab=Description)
    题意：给定二维矩阵，0表示空地,1表示障碍，给定起始点和终止点（不同），球只有撞到障碍或边界才能选择改变方向，判断球能否停在终止点（经过不算）
    总结：搜索。（1）BFS。队列里始终存放的是允许改变方向的位置，从队列取出点后，一直朝某个方向走直到撞到障碍或边界，若未访问过则入队。（2）DFS。需记录当前运行的方向。
    错误：思路不清晰。
+ [491. Increasing Subsequences](https://leetcode.com/problems/increasing-subsequences/?tab=Description)
    题意：给定数组，求所有非递减子序列
    总结：回溯，每次循环用set记录已遍历的下一值，当已遍历过时，continue跳过。以往利用while循环或continue方法跳过重复的值的前提是排序后相同的数排在一起，同时所求集合不要求数值的相对顺序（Leetcode 90. Subset II），而此题不能排序，相同的数也不一定相邻a，
    错误：不会如何去重
+ [493. Reverse Pairs](https://leetcode.com/problems/reverse-pairs/)
    题意：给定整数数组，求满足i < j 且 nums[i] > 2 * nums[j]的数对个数。
    总结：二叉索引树（树状数组）。将数组各元素乘2并与原数组合并去再排序。求解乘2后的数组的数对个数（实际与原数组相等）。使用二叉搜索树在数组升序情况下复杂度是O(n^2)超时
    错误：超时
+ [495. Teemo Attacking](https://leetcode.com/problems/teemo-attacking/)
    题目：给定冷冻技能释放时刻数组和冷冻时间，求冷冻的总时间
    思路：当两次技能释放间隔大于冷冻时间时，总和增加冷冻时间，否则总和增加间隔。
    错误：没有考虑到时刻数组为空的边界情况
+ [496. Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)
    题意：给定nums1和nums2两数组，其中nums1是nums2的子集。对于nums1中每个元素x，求x在nums2中位置右侧序列中第一个大于x的数。
    总结：递减单调栈。顺序遍历nums2数组，对于元素y，若栈非空且栈顶小于y，则出栈同时记录栈顶的所求值为y，重复出栈。然后入栈y。
    错误：不会
+ [501. Find Mode in Binary Search Tree](https://leetcode.com/problems/find-mode-in-binary-search-tree/#/description)
    题意：包含重复元素的BST，求出现次数最多的全部元素的值。
    总结：中序遍历。相等的值在遍历过程中一定相邻，只维护当前元素的出现次数即可。使用last记录前一元素。
+ [502. IPO](https://leetcode.com/problems/ipo/)
    题意：给定资金W，多个项目完成所需最少资金及项目收益，至多用资金完成k个项目，求最终的资金W的最大值。完成项目不需要消耗资金，但必须满足当前资金W不小于项目要求的最小资金。
    总结：堆、贪心。顺序完成各个项目。使用堆heap1对项目按所需资金排序，从堆中取出所需资金小于等于W的项目放入堆heap2中再按照项目收益排序，从heap2中取出堆顶即为当前项目收益，将收益累加到W上。重复此操作直至没有可以进行的项目或达到k个项目。
    错误：边界条件，没有项目可以完成时直接退出
+ [503. Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/#/description)
    题意：循环数组，求每个元素右侧第一个大于它的数。
    总结：单调栈。栈底向栈顶方向呈递减。正序处理和逆序处理均可。
+ [505. The Maze II](https://leetcode.com/problems/the-maze-ii/?tab=Description)
    题意：给定二维矩阵，0表示空地,1表示障碍，给定起始点和终止点（不同），球只有撞到障碍或边界才能选择改变方向，求球停止在终止点的最小路径长度，不能停在终止点则返回-1.
    总结：BFS。队列里存放一步步移动得到的点，需要记录位置来的方向和离起始点的路径长度。若当前位置下一步不可达，则该点可以改变方向，此时将4个方向的下一位置加入队列。
    错误：思路不清晰。
+ [507. Perfect Number](https://leetcode.com/problems/perfect-number/#/description)
    题意：判断一个正整数是否是它除自身外的所有因子的和。
    总结：注意两个因子相等的情况要只算一次。
    错误：边界条件1直接返回false。
+ [513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/#/description)
    题意：求二叉树最后一层最左侧的节点的值
    总结：广度优先最后一个值。深度优先遍历最深的值。从右向左遍历。
+ [514. Freedom Trail](https://leetcode.com/problems/freedom-trail/#/description)
    题意：给定环形的字母表盘ring和单词key，旋转表盘拼出单词。12点钟方向为指针位置，对于表盘字符串的起始位置0。求最少的旋转次数。
    总结：动态规划。贪心算法每次旋转最近的下一个字母不一定能全局最优。二维dp，第一维是单词要匹配的位置，第二维是ring当前处于指针位置的字符=下标，dp[i][j]状态转移条件是对于表盘上字母为key[i]的字母ring[k]，则有dp[i][j] = Math.min(dp[i][j], Math.min(dist, n - dist) + dp[i + 1][k])，dist = Math.abs(j - k)。其中Math.min(dist, n - dist)对应于选择顺时针旋转和逆时针旋转中的较近的方式。
+ [516. Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/#/description)
    题意：求给定字符串s的最长回文子序列的长度
    总结：动态规划。dp[i][j]表示s[i:j]内的最长回文子序列的长度。
+ [523. Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/#/description)
    题意：给定数组nums和整数k，判断是否存在长度不小于2的连续子段和等于n * k，其中n为自然数。
    总结：前缀和取模。用map记录模值首次出现的下表，当再次出现该模值时说明两次出现该模值中间的序列的和等于n * k。需要注意k等于0的时候，不能取模，直接存储前缀和的值即可。类似题目Leetcode 525。
    错误：k == 0的边界条件，使用数组存储模值导致内存超限
+ [525. Contiguous Array](https://leetcode.com/contest/leetcode-weekly-contest-20/problems/contiguous-array/)
    题意：给定数组，数组元素为0或1，求包含0,1个数相等的最长连续子序列的长度。
    总结：将数组中的0转化成-1，求总和为0的子序列的最大长度。求数组前缀序列和，利用sum[i+1:j] = s[j] - s[i]求解。即找到s[j]与s[i]相等的索引差的最大值。注意对于整个数组-1和1个数相等的情况，需要预先在map插入(0, -1)解决。
    错误：不会
+ [526. Beautiful Arrangement](https://leetcode.com/contest/leetcode-weekly-contest-20/problems/beautiful-arrangement/) 
    题意：用[1, n]这n个整数组成序列，使序列满足第i个位置的元素满足nums[i] % i == 0或i % nums[i] == 0。求总共可以构成多少个这样的序列。
    思路：回溯。实际上与求全排列的问题类似，只是只有在满足上述条件时才会交换两位置的元素再递归求解。搜索树的每层对应于排列中第i位各种可能的值。
+ [527. Word Abbreviation](https://leetcode.com/problems/word-abbreviation/#/description)
    题意：给定若干单词，其缩写格式为：首字母 + 中间长度 + 尾字母。当存在2个及以上的单词缩写冲突时，扩展其缩写前缀直到不冲突。求单词内所有单词的缩写。
    总结：直接用Trie树不对。先求各单词的最简缩写，再针对各缩写冲突的子集单独扩展前缀。冲突缩写子集的处理可以（1）使用Trie，每个节点记录前缀的次数，当只有1次时，说明不冲突，否则一直向下直至不冲突（2）每次处理一个字符串，扩展字符串当前前缀，重新计算各缩写，直至后续其他单词的前缀与之不冲突。
    错误：当中间长度为1时，应该保留原串，不缩写。
+ [529. Minesweeper](https://leetcode.com/problems/minesweeper/#/description)
    题意：给定扫雷状态面板和点击位置，求下一状态
    总结：广度优先遍历。
    错误：BFS时对已进入队列的的元素没有标识，导致多次入队超时。
+ [532. K-diff Pairs in an Array](https://leetcode.com/problems/k-diff-pairs-in-an-array/#/description)
    题意：求数组中绝对值差为k的不同数对
    总结：使用HashMap统计各数出现的次数。遍历map的所有key，若k == 0，则统计key出现次数大于等于2的个数；否则，统计key + k存在于map里的个数。（这里没有统计key - k的目的是去重）
    错误：这都不会！！
+ [533. Lonely Pixel II](https://leetcode.com/problems/lonely-pixel-ii/#/description)
    题意：给定B、W黑白像素二维矩阵和整数N，求满足如下条件的点（R，C）：（1）第R行和第C列均恰好有N个像素（2）在列C有黑像素的所有行应该与第R行完全相同。
    总结：题意不是很容易弄清。所求问题等价于黑色像素（R,C）所在行列均恰有N个像素，且恰好有N个这样的行R。统计每行、每列的黑色像素数。把行转化成字符串，用HashMap记录字符串出现的次数。
    错误：思路太乱。
+ [539. Minimum Time Difference](https://leetcode.com/problems/minimum-time-difference/#/description)
    题意：给定时刻(hh:mm)数组，可能包含重复，求最小时间差（单位分钟）。
    总结：桶排序，时间上是找环上最近的两个点的距离。特殊处理：用first和last记录环上的第一个点和最后一个点，用于求解两点间距离，再与O(n)遍历求得的最小距离比较即可。
    错误：没有考虑到重复时刻的情况（直接返回0）
+ [540. Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/#/description)
    题意：给定有序数组，其中只有一个数字只出现了一次，其他数字均出现两次。找出只出现一次的这个数字。
    总结：二分法。题目可转化为找出第一个满足nums[m] != nums[m + 1]关系的下标为偶数的数字。
+ [542. 01 Matrix](https://leetcode.com/problems/01-matrix/#/description)
    题意：给定01矩阵，求所有位置到最近的0的最小距离
    总结：最小距离使用BFS。将所有为0的位置入队，非0位置的距离置为-1，然后出队p，对p的四个方向进行更新，更新条件为位置可达且其对应距离值为-1。（因为是广度优先搜索，所以最先被更新的一定是由最近的0更新的）
    错误：不会。。。
+ [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/#/description)
    题意：求二叉树最长直径长度。
    总结：后序遍历。利用最大深度的思路，用直径穿过根节点的最长路径更新全局最大值。
    错误：注意是直径长度，不是直径上节点个数。
+ [544. Output Contest Matches](https://leetcode.com/problems/output-contest-matches/#/description)
    题意：给定n个NBA季后赛排名，求全部的场次安排，每轮比赛都是排名第i的球队与排名第n + 1 - i的球队比赛。
    总结：递归处理。用ArrayList<String>存储每轮比赛的结果。
+ [547. Friend Circles](https://leetcode.com/problems/friend-circles/#/description)
    题意：n个同学，给定任意两人间的朋友关系，求朋友圈的个数，朋友关系可以传递。
    总结：并查集求集合个数。
+ [548. Split Array with Equal Sum](https://leetcode.com/problems/split-array-with-equal-sum/#/description)
    题意：给定数组，判断是否能找到3个下标，使得下标分割成的4个子段和相等。各子段均不能为空。
    总结：O(n^2)。假设分割点为i,j,k。外层循环遍历j的所有可能，内层第一个循环用set记录能够将左段二等分的单子段和，第二循环判断是否存在k将右段等分，且单子段和存在于set中，存在则立即返回true；全部遍历完未找到分割点则返回false
+ [552. Student Attendance Record II](https://leetcode.com/problems/student-attendance-record-ii/description/)
    题意：以A,L,P作为元素，构造长度为n，A的个数小于等于1，且连续L的个数小于等于2的字符串。求满足要求的字符串的个数。
    总结：（1）动态规划O(n),O(1)。dp[i][j][k]表示A的个数为j，以k个L结尾的字符串的个数。（2）矩阵快速幂可优化值O(logn)时间复杂度
    错误：应提前取模避免溢出
+ [553. Optimal Division](https://leetcode.com/problems/optimal-division/#/description)
    题意：给定若干正整数（范围[2, 1000]），相邻整数间是除的关系，要求通过加括号的方式改变计算顺序，使其计算结果值最大，求计算方式。要求所加的括号最简无冗余。
    总结：（1）直接。最大值一定是第一个数除以后续所有数计算的最小值得到的，后面数的最小值一定是连除得到的。因此只需在nums[1:n-1]外加一括号即可（2）动态规划。max[i][j] = Math.max(max[i][k] / min[k+1][j])，min[i][j] = Math.min(min[i][k], max[k+1][j])，其中 i <= k < j。为了构造最后的结果，可用maxSplit[i][j]和minSplit[i][j]记录max[i][j]和min[i][j]的分割位置。递归构造时，只需在a/b中的b上加括号即可。
+ [554. Brick Wall](https://leetcode.com/problems/brick-wall/#/description)
    题意：给定二维数组表示一面墙，每维数组表示每层各砖块的宽度，要求画一条竖线，使得竖线穿过的砖块最少。竖线不能是墙的两个边界。
    总结：HashMap对各层砖块的右边界横坐标计数（不含每层最后一块砖的边界），得到计数最多的边界位置的数量，用层数减去该数即可。
+ [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/#/description)
    题意：给定整数数组，求连续子段和为k的子段个数
    总结：O(n), 前缀和 + HashMap计数（使用map记录前缀和出现的次数）。
+ [563. Binary Tree Tilt](https://leetcode.com/problems/binary-tree-tilt/#/description)
    题意：给定二叉树，求二叉树的倾斜度。二叉树节点的倾斜度定义为左、右子树节点值之和的绝对差值。二叉树的倾斜度定义为所有节点倾斜度之和。null节点倾斜度为0.
    总结：后续遍历。全局变量记录二叉树倾斜度，后续遍历递归返回值为当前节点对应树的节点之和。
+ [565. Array Nesting](https://leetcode.com/problems/array-nesting/#/description)
    题意：给定长度为N的数组nums，数组元素恰好为[0, N-1]。集合S[K]（0 <= K < N）定义为S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }，其中S[K]为有限集合且不含重复元素。求最大S[K]的元素个数。
    总结：由于映射关系，实际上N个元素会被划分为若干个环（一个或多个，环上的边即映射关系）。（1）O(n)解法。遍历各点。对于每个点，沿映射关系一直向前遍历，对已遍历过的点将其nums[i]置为-1作为已访问的标记，向前遍历的步数即为环的长度，也即集合的大小。最后取集合大小最大值即可。（2）并查集。
+ [567. Permutation in String](https://leetcode.com/problems/permutation-in-string/#/description)
    题意：给定字符串s1和s2，判断s2是否包含s1的一个排列。
    总结：滑动窗口。即判断s2是否存在一个子段满足该子段字母组成与s1相同。首先使用HashMap记录s1中各字符出现次数，使用count（初始值为s1的长度）记录窗口滑动过程中有效的操作次数。当count为0即返回true。
    错误：开始从窗口剔除元素的判断条件错误，应该是 i >= s1.length()（错误是没有加等号）
+ [572. Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/#/description)
    题意：给定两个二叉树s和t，判断t是否与s的某颗子树完全一样。
    总结：isSame(s, t) || (s != null && (isSubtree(s.left, t) || isSubtree(s.right, t)))。
    错误：不是isSame(s, t) || (s != null && (isSame(s.left, t) || isSame(s.right, t)))。
+ [576. Out of Boundary Paths](https://leetcode.com/problems/out-of-boundary-paths/#/description)
    题意：给定m * n的方格矩形及球的坐标，球最多可移动N步。求球移出矩阵的所有方法数。
    总结：动态规划。f(s,i,j) = f(s-1,i-1,j) + f(s-1,i+1,j) + f(s-1,i,j-1) + f(s-1,i,j+1)。注意边界处理。通过滚动数组可优化至m * n的空间。
    错误：不会，每次做加法都有取模，否则可能溢出。
+ [581. Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/#/description)
    题意：给定整数数组，求使数组有序的最小待排序区间的长度。
    总结：（1）O(n),O(n)，先统计每个位置左侧最大值leftMax[i]、右侧最小值rightMin[i]。分别从左和从右找到两个边界。（2）O(n),O(1)，没弄懂
    错误：边界条件，恰好数组有序
+ [583. Delete Operation for Two Strings](https://leetcode.com/problems/delete-operation-for-two-strings/#/description)
    题意：给定两个字符串w1和w2，每次可以删除其中一个字符串的任一字符。求使两个字符串变成相同所需的最少删除次数。
    总结：动态规划。f[i][j]表示w1[0:i]和w2[0:j]变相同所需的最少删除次数。则当w1[i+1] = w2[j+1]时，f[i+1][j+1] = f[i][j]；否则f[i+1][j+1] = min(f[i+1][j], f[i][j+1]) + 1。与72. Edit distance题目类似。
+ [593. Valid Square](https://leetcode.com/problems/valid-square/#/description)
    题意：给定4个点的横纵坐标，判断四个点能否组成正方形。
    总结：首先确定没有重叠点。再判断任意三个点是否组成等腰直角三角形。
    错误：没有判断重叠点的边界情况。
+ [594. Longest Harmonious Subsequence](https://leetcode.com/problems/longest-harmonious-subsequence/#/description)
    题意：给定整数数组，求满足最大值和最小值差值恰好为1的子序列的最大长度。
    总结：使用map存储各数字的个数,再加上n - 1或n + 1的个数，再去更新max。
    错误：想太复杂了
+ [605. Can Place Flowers](https://leetcode.com/problems/can-place-flowers/#/description)
    题意：给定0，1数组flowerbed，0表示没有种花，1表示已经种花，给定整数n，求能否种n束话，且没有任意两花相邻。（输入数组没有花相邻）。
    总结：(1) 贪心。当flowerbed[i] == 0，判断前后两位置是否均为0，若是则在此位置种花(flowerbed[i] = 1)，同时计数加1。(2) DP。当flowerbed[i] == 0时，dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);dp[i + 1][1] = dp[i][0] == -1 ? -1 : dp[i][0] + 1;当flowerbed[i] == 1时，dp[i + 1][0] = -1;dp[i + 1][1] = dp[i][0]。

+ [611. Valid Triangle Number](https://leetcode.com/problems/valid-triangle-number/#/description)
    题意：给定整数数组，取三个整数组成三角形。求所有能组成三角形的组数。
    总结：O(n^2)。先排序，再利用双指针。
+ [617. Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/#/description)
    题意：将两二叉树叠加。
    总结：递归遍历。
+ [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/#/description)
    题意：给定若干字母表示任务，相同字母表示同类任务，每个任务执行所需时间是1。CPU执行任务时，同类任务至少中间间隔n个其他任务或空闲。求完成任务所需的最小时间。
    总结：贪心。统计各类任务的个数，每次安排优先安排个数多的任务（利用堆heap进行排序），然后取出Math.min(n + 1, heap.size())个任务，然后将其次数都减1，再放回堆中，直至堆空。除最后一次外，每次取出放回都消耗了时间n + 1（可能包含空闲），最后一次消耗heap.size()时间。与题目358. 
Rearrange String k Distance Apart 类似。
    错误：不会。
+ [623. Add One Row to Tree](https://leetcode.com/problems/add-one-row-to-tree/#/description)
    题意：给定二叉树，在二叉树的d层，增加一行值为v的节点。
    总结：层次遍历获取到二叉树第d-1层的节点，在增加节点即可。可使用dummy节点处理d = 1的情况。
+ [628. Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers/#/description)
    题意：给定整数数组（长度>=3），从其中选3个数，求乘积的最大值。
    总结：只需要找出max1,max2,max3,min2,min1（min和max值可能有重叠），那么最大值为Math.max(max1 * max2 * max3, max1 * min1 * min2)。
    错误：想的太复杂
+ [633. Sum of Square Numbers](https://leetcode.com/problems/sum-of-square-numbers/#/description)
    题意：给定整数c，判断是否存在a,b，使得a^2 + b^2 = c。
    总结：双指针。l = 0, r = (int) sqrt(c) + 1。循环条件 l <= r
