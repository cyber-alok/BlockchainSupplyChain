package com.alok.blockchain;

import java.util.ArrayList;

public class Blockchain {
    public ArrayList<Block> chain;

    public Blockchain() {
        this.chain = new ArrayList<>();
        chain.add(createGenesisBlock());
    }

    private Block createGenesisBlock() {
        return new Block(0, "Genesis Block", "0", 0.0);  // First block with index 0
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(String data, double temperature) {
        int newIndex = getLatestBlock().index + 1;
        Block newBlock = new Block(newIndex, data, getLatestBlock().hash, temperature);
        chain.add(newBlock);
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block current = chain.get(i);
            Block previous = chain.get(i - 1);

            if (!current.hash.equals(current.calculateHash())) return false;
            if (!current.previousHash.equals(previous.hash)) return false;
        }
        return true;
    }
}
