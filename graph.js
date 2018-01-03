/*
	Breadth First Traversal or BFS for a Graph.
*/

function Graph() {
	this.numEdges = 0;
	this.vertices = [];
	this.edges = [];
}

Graph.prototype.addVertice = function(vertex) {
	// Add the vertex
	this.vertices.push(vertex);
	// Add an array for vertexes edges
	this.edges[vertex] = [];
}

Graph.prototype.removeVertice = function(vertex){
	this.vertices
}

Graph.prototype.addEdge = function(x, y) {
	// Add edges going both ways
	this.edges[x].push(y);
	this.edges[y].push(x);
	this.numEdges++;
}

Graph.prototype.print = function(){
	for(var vertex in this.vertices){
		var currVertex = this.vertices[vertex]
		console.log();		
		console.log(' (Vertex ' + currVertex + ') Edges: ', this.edges[currVertex].join(' -> '));
	}
}

var graph = new Graph();

graph.addVertice(1);
graph.addVertice(2);
graph.addVertice(3);
graph.addVertice(4);

graph.addEdge(1, 2);
graph.addEdge(1, 4);
graph.addEdge(2, 3);


graph.print();
