/*
Copyright (c) 2009-2010 Mikko Mononen memon@inside.org
recast4j copyright (c) 2015-2019 Piotr Piastucki piotr@jtilia.org

This software is provided 'as-is', without any express or implied
warranty.  In no event will the authors be held liable for any damages
arising from the use of this software.
Permission is granted to anyone to use this software for any purpose,
including commercial applications, and to alter it and redistribute it
freely, subject to the following restrictions:
1. The origin of this software must not be misrepresented; you must not
 claim that you wrote the original software. If you use this software
 in a product, an acknowledgment in the product documentation would be
 appreciated but is not required.
2. Altered source versions must be plainly marked as such, and must not be
 misrepresented as being the original software.
3. This notice may not be removed or altered from any source distribution.
*/
package org.recast4j.demo.sample;

import java.util.List;

import org.recast4j.demo.draw.RecastDebugDraw;
import org.recast4j.demo.geom.DemoInputGeomProvider;
import org.recast4j.demo.settings.SettingsUI;
import org.recast4j.detour.NavMesh;
import org.recast4j.detour.NavMeshQuery;
import org.recast4j.recast.RecastBuilder.RecastBuilderResult;
import org.recast4j.recast.RecastConfig;

public class Sample {

    private DemoInputGeomProvider inputGeom;
    private NavMesh navMesh;
    private NavMeshQuery navMeshQuery;
    private final SettingsUI settingsUI;
    private RecastConfig recastConfig;
    private List<RecastBuilderResult> recastResults;
    private boolean changed;

    public Sample(DemoInputGeomProvider inputGeom, List<RecastBuilderResult> recastResults, NavMesh navMesh,
            SettingsUI settingsUI, RecastDebugDraw debugDraw) {
        this.inputGeom = inputGeom;
        this.recastResults = recastResults;
        this.navMesh = navMesh;
        this.settingsUI = settingsUI;
        setQuery(navMesh);
        changed = true;
    }

    private void setQuery(NavMesh navMesh) {
        navMeshQuery = navMesh != null ? new NavMeshQuery(navMesh) : null;
    }

    public DemoInputGeomProvider getInputGeom() {
        return inputGeom;
    }

    public RecastConfig getRecastConfig() {
        return recastConfig;
    }

    public List<RecastBuilderResult> getRecastResults() {
        return recastResults;
    }

    public NavMesh getNavMesh() {
        return navMesh;
    }

    public SettingsUI getSettingsUI() {
        return settingsUI;
    }

    public NavMeshQuery getNavMeshQuery() {
        return navMeshQuery;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void update(DemoInputGeomProvider geom, RecastConfig recastConfig, List<RecastBuilderResult> recastResults, NavMesh navMesh) {
        inputGeom = geom;
        this.recastConfig = recastConfig;
        this.recastResults = recastResults;
        this.navMesh = navMesh;
        setQuery(navMesh);
        changed = true;
    }
}
