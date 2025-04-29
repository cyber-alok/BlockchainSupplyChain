package com.alok.blockchain;

public class Main {
    public static void main(String[] args) {
        Blockchain supplyChain = new Blockchain();

        // Adding blocks to simulate supply chain movement
        supplyChain.addBlock("Supplier -> Manufacturer", 22.5);
        supplyChain.addBlock("Manufacturer -> Distributor", 23.0);
        supplyChain.addBlock("Distributor -> Retailer", 24.0);

        // Print block details
        for (Block b : supplyChain.chain) {
            System.out.println("Block Index: " + b.index);
            System.out.println("Data: " + b.data);
            System.out.println("Temperature: " + b.temperature + " °C");
            System.out.println("Hash: " + b.hash);
            System.out.println("Timestamp: " + b.formattedTimeStamp);
            System.out.println("Previous Hash: " + b.previousHash);
            System.out.println("---------------------------");
        }

        // Check if the blockchain is valid
        System.out.println("Is Blockchain Valid? " + supplyChain.isChainValid());
    }
}
