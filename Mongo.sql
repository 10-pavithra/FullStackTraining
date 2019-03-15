> use test
switched to db test
>   db.users.insertMany( [
...       {     "email" : "test@test.com","password" : "Test@123"},
...  {     "email" : "test1@test.com","password" : "Test@123"}
...     ] );
{
        "acknowledged" : true,
        "insertedIds" : [
                ObjectId("5c8a86fa9eb904c4fd7b6a72"),
                ObjectId("5c8a86fa9eb904c4fd7b6a73")
        ]
}
>   db.users.insertMany( [
...       {     "email" : "maker@test.com","password" : "Test@123"},
...  {     "email" : "checker@test.com","password" : "Test@123"}
...     ] );
{
        "acknowledged" : true,
        "insertedIds" : [
                ObjectId("5c8a885a9eb904c4fd7b6a74"),
                ObjectId("5c8a885a9eb904c4fd7b6a75")
        ]
}