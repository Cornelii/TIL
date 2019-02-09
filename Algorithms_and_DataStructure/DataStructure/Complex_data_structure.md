# Complex Data Structures


## I. Hash Map Methodology
Data is stored in terms of table.
And, Index is used to access them.

And, Hash function : {things} => {the index}

**Components of hash**
1. Associated data
2. An array of a fixed size
3. Hash function.

#### 1. There can be various types of hash function.
The simpler, the better. Because hash calculation is done every moment to access data in hash bucket.

The output of hash function must not be larger than size of array that includes indices and data. For this reason. `mod` is often used.

General flow to get index from hash function (hash map): data(key)-> hash code -> mod operation to get index
#### 2. Hash Collision
Hash function is kind of compressing function.
The situation of same hash for two different keys is called hash collision.
(Separate chaining, Open addressing are common ways to overcome this.)

#### 3. Separate Chaining (with Linked list at each index-pointed position.)
Just link the data in terms of linked list at the index.

#### 4. To get values in separated chaining. Save Key.
another key is saved to access in linked list
1. data(key) => [hash function => hashcode => manipulation] (hash map) => index
2. At the index. it find wanted value iteratively using other key in the linked list.


#### 5. Open Addressing
There are also several means in open addressing like probing.
Probing: Continue to find empty index.

To acheive data from probing.
First find by hash. If <span style="color:blue">data(key)</span> does not coincide, go on in index matching key until it finds the same key.

#### 6. Clustering and Quadratic Probing
One probing to avoid hash collosion causes other hash collision. => Clustering
Sometimes a probing itself triggers numerous hash collision.
Quadratic Probing : rather than 1index jump, 4index a step.


## II.

## III.