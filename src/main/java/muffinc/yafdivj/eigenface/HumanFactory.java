/*
 * Copyright (c) 2015.  Jun Zhou
 *
 * YaF-DIVJ, Yet another Face Detection Image Viewer in Java
 * <p/>
 * This file is part of YaF-DIVJ.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * zj45499 (at) gmail (dot) com
 */

package muffinc.yafdivj.eigenface;

import muffinc.yafdivj.datatype.YafImg;
import muffinc.yafdivj.datatype.Human;

import java.io.File;
import java.util.HashMap;

public class HumanFactory {
    public TrainingEngine engine;

    public HashMap<String, Human> nameTable;
    public HashMap<File, YafImg> frogImgTable;

    public HumanFactory(TrainingEngine engine) {
        this.engine = engine;
        nameTable = new HashMap<>();
        frogImgTable = new HashMap<>();
    }

    private boolean hasHuman(String name) {
        return nameTable.containsKey(name);
    }

    public boolean hasImg(YafImg yafImg) {
        return frogImgTable.containsValue(yafImg);
    }

    public boolean hasImg(File file) {
        return frogImgTable.containsKey(file);
    }

    public Human newHuman(String name) {
        if (!hasHuman(name)) {
            Human newHuman = new Human(name);
            nameTable.put(name, newHuman);
            return newHuman;
        } else {
            throw new IllegalArgumentException(name + " already exist in the HumanFactory, Please hasHuman() first.");
        }
    }




//    public void addImgToHuman(FrogImg frogImg, String name, opencv_core.CvRect cvRect) {
//        if (hasHuman(name)) {
//            Human human = locateHuman(name);
//            human.linkWithImgCvRect(frogImg, cvRect);
//            frogImg.setCvRectHuman(locateHuman(name), cvRect);
////            frogImgTable.put(frogTrainImg.file, frogTrainImg);
//        } else {
//            throw new IllegalAccessError("This person is not in the HumanFactory, Please hasHuman() and create first.");
//        }
//    }
}
