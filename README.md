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
