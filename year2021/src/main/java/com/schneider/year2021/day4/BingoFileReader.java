package com.schneider.year2021.day4;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
public class BingoFileReader {

    private ArrayList<BingoBoard> bingoBoards = new ArrayList<>();
    private ArrayList<Integer> calledNumbers;

    public BingoFileReader(File file){
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            this.calledNumbers = Arrays.stream(br.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));

            String line;
            int rowCount = 1;
            int rowLimit = 5;
            ArrayList<ArrayList<Integer>> boardArray = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if(!line.isEmpty()) {
                    
                    boardArray.add(Arrays.stream(line.split(" "))
                            .filter(s -> !s.isEmpty())
                            .map(Integer::parseInt)
                            .collect(Collectors.toCollection(ArrayList::new)));

                    if(rowCount == rowLimit) {
                        this.bingoBoards.add(new BingoBoard( new ArrayList<>(boardArray)));
                        boardArray = new ArrayList<>();
                        rowCount = 1;
                    } else {
                        rowCount ++;
                    }
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
