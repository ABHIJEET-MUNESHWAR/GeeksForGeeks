# Directed Graph Cycle

## Difficulty: Medium

## Platform: GeeksForGeeks

## Problem Link
[View Problem](https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1)

## Solved On
23 Aug 2026 at 02:55 pm

<h2><a href="https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1">Directed Graph Cycle</a></h2><h3>Difficulty Level: Medium</h3><hr><p><span style="font-size: 14pt;">Given a directed graph with <strong>V</strong> vertices numbered from 0 to V - 1 and E directed edges. The graph is represented using a 2D array <strong>edges[][]</strong> of size E, where each entry edges[i] = [u, v] denotes a directed edge from vertex u to vertex v.</span></p>
<p><span style="font-size: 14pt;">Check whether the graph contains any cycle. Return true if there exists at least one cycle in the graph; otherwise, return false.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>V = 4, edges[][] = [[0, 1], [1, 2], [2, 0], [2, 3]]</span>

<span style="font-size: 18px;"><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700218/Web/Other/blobid0_1761112751.jpg" width="238" height="222"></span>

<span style="font-size: 18px;"><strong>Output:</strong> true
<strong>Explanation</strong>: The diagram clearly shows a cycle 0 -&gt; 1 -&gt; 2 -&gt; 0</span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]<strong><br></strong></span>
<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700218/Web/Other/blobid1_1761112778.jpg" width="244" height="216"><br><span style="font-size: 18px;"><strong>Output:</strong> false
<strong>Explanation</strong>: no cycle in the graph</span></pre>
<p><span style="font-size: 18px;"><strong style="font-size: 18px;">Constraints:</strong><br><span style="font-size: 18px;"><span style="font-size: 18px;">1 ≤ V ≤ 10<sup>5</sup></span><br><span style="font-size: 18px;">0 ≤ E ≤ 10<sup>5</sup></span><br></span></span><span style="font-size: 18px;"><span style="font-size: 18px;">0 ≤ edges[i][0], edges[i][1] &lt; V</span></span></p>