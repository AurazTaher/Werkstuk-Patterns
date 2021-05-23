// voer de main functie direct uit wanneer u html laad
document.addEventListener("DOMContentLoaded",main)
let aantalPizzas = 100;
let orders = []

function main(){
    let person = createPerson("Auraz","Taher")

    let kipTopping = createProduct("Kip topping",0.5,10);
    let olijfTopping = createProduct("Olijf topping",0.5,0.5,kipTopping)
    let mainPizza = createProduct("pizza",5.0,10,olijfTopping)
    let order = createOrder(person,mainPizza,0.5,discountFunctionTotal)

    let groentjes = createProduct("groentjes",1,2);
    let olijven = createProduct("Olijf topping",0.5,0.5,groentjes)
    let veganPizza = createProduct("Vegan Pizza",5.0,10,olijven)
    let order2 = createOrder(person,veganPizza)

    handleOrders(add(add(orders,order),order2),aantalPizzas)
}


function createPerson(firstName, lastName){
    return {firstname: firstName, lastname: lastName, update: function(order){
        console.log(`${this.firstname} ${this.lastname}'s pizza is ready for pickup, the total cost came to ${order.price()}`)
    }}
}


function createProduct(productName, productPrice,prepTime, parentProduct = undefined){
    return {name: productName, price: productPrice, parent: parentProduct,totalPrice: function(){
        let totalprice = 0;
        if (this.parent != undefined){
            totalprice = this.parent.totalPrice()
        }
        return totalprice + this.price;
    },time: prepTime, totalPrepTime: function(){
        let totalTime = 0;
        if (this.parent != undefined){
            totalTime = this.parent.totalPrepTime()
        }
        return this.time + totalTime;
    }}
}

function createOrder(person,product,discountPercentage = 0,discountFunction = undefined){
    return {orderer: person, product: product, price: function(){
        if (discountFunction != undefined){
            return product.totalPrice() - discountFunction(this,discountPercentage)
        }
        return product.totalPrice()
    }, time: product.totalPrepTime(),discountfunction: discountFunction}
}

function calculateTotalOrderPrice(order,discountFunction,discountPercentage = undefined){
    if (discountFunction == undefined){
        return order.price;
    }
    return order.price - discountFunction(order,discountPercentage)
}

function discountFunctionTotal(order, discountPercentage){
    let totalPrice = order.product.totalPrice();
    return totalPrice - (totalPrice * discountPercentage)
}

function discountFunctionLimit(order, discountPercentage){
    let totalprice = order.product.totalPrice();
    if (totalprice >= 10){
        return totalprice * discountPercentage
    }
    return 0;
}

function add(list, item){
    return list.concat([item])
}

function handleOrders(orders_,aantalPizzasLeft){
    let orders = orders_.slice()
    if (orders.length > 0 && aantalPizzasLeft > 0){
        let orderToHandle = orders.sort((a,b) => sortOnPriceTime(a,b))[0] 
        // update the orderer that his pizza is ready for pickup
        orderToHandle.orderer.update(orderToHandle)
        handleOrders(orders.slice(1),aantalPizzasLeft-1)
    }
    else{
        console.log("All orders have been handled or all pizza dough's are gone")
    }
}

function sortOnPriceTime(a,b){
    let priceTimeA = a.price()/a.time; 
    let priceTimeB = b.price()/b.time;
    return priceTimeB - priceTimeA; 
}

