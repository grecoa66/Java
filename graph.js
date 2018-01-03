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
	// Get the vertex index
	var index = this.vertices.indexOf(vertex);
	
	if(index >= 0){
		// Splice the vertex out of the vertices
		this.vertices.splice(index, 1);
	
		// Remove every edge this vertex shares
		while(this.edges[vertex].length){
			var adjacentVertex = this.edges[vertex].pop();
			this.removeEdge(adjacentVertex, vertex);
		}
	}else{
		console.log("That vertex does not exist");
	}
}

Graph.prototype.addEdge = function(x, y) {
	// Add edges going both ways
	this.edges[x].push(y);
	this.edges[y].push(x);
	this.numEdges++;
}

Graph.prototype.removeEdge = function(adjacentVertex, vertex) {
	var index = this.edges[adjacentVertex].indexOf(vertex);
	if(index >= 0){
		this.edges[adjacentVertex].splice(index, 1);
		this.numEdges--;
	}else{
		console.log("This edge does not exist and can't be deleted.");
	}

	index = this.edges[vertex].indexOf(adjacentVertex);
	if(index >= 0){
		this.edges[vertex].splice(index, 1);
		this.numEdges--;
	}else{
		console.log("This edge does not exist and can't be deleted.");
	}
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
graph.addVertice(5);

graph.addEdge(1, 2);
graph.addEdge(1, 4);
graph.addEdge(2, 3);
graph.addEdge(3, 5);
graph.addEdge(4, 5);
graph.addEdge(1, 5);

graph.print();

graph.removeEdge(1, 2);

graph.print();
