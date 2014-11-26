package org.graphwalker.core.algorithm;

/*
 * #%L
 * GraphWalker Core
 * %%
 * Copyright (C) 2005 - 2014 GraphWalker
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import org.graphwalker.core.machine.Context;
import org.graphwalker.core.machine.TestExecutionContext;
import org.graphwalker.core.model.Edge;
import org.graphwalker.core.model.Model;
import org.graphwalker.core.model.Vertex;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Nils Olsson
 */
public class DepthFirstSearchTest {

    private static final Vertex v00 = new Vertex().setName("v00");
    private static final Vertex v01 = new Vertex().setName("v01");
    private static final Vertex v10 = new Vertex().setName("v10");
    private static final Vertex v20 = new Vertex().setName("v20");
    private static final Vertex v31 = new Vertex().setName("v31");

    private static final Edge e1 = new Edge().setName("e1").setSourceVertex(v00).setTargetVertex(v01);
    private static final Edge e2 = new Edge().setName("e2").setSourceVertex(v00).setTargetVertex(v10);
    private static final Edge e3 = new Edge().setName("e3").setSourceVertex(v10).setTargetVertex(v20);
    private static final Edge e4 = new Edge().setName("e4").setSourceVertex(v20).setTargetVertex(v31);
    private static final Edge e5 = new Edge().setName("e5").setSourceVertex(v01).setTargetVertex(v31);


    private static final Vertex ve0 = new Vertex().setName("ve0");
    private static final Vertex ve1 = new Vertex().setName("ve1");
    private static final Edge ee1 = new Edge().setName("e1").setSourceVertex(ve0).setTargetVertex(ve1);

    private static final Model model = new Model()
            .addEdge(e1)
            .addEdge(e2)
            .addEdge(e3)
            .addEdge(e4)
            .addEdge(e5)
            .addEdge(ee1);

    @Test
    public void connectedComponent() {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(new TestExecutionContext().setModel(model.build()));
        Assert.assertThat(depthFirstSearch.getConnectedComponent(v00.build()).size(), is(10));
        Assert.assertThat(depthFirstSearch.getConnectedComponent(ve0.build()).size(), is(3));
    }
}
