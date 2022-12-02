
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import OrderStatusView from "./components/OrderStatusView"
import OrderStatusViewDetail from "./components/OrderStatusViewDetail"
import MenuView from "./components/MenuView"
import MenuViewDetail from "./components/MenuViewDetail"
import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import OrderProcessingManager from "./components/listers/OrderProcessingCards"
import OrderProcessingDetail from "./components/listers/OrderProcessingDetail"

import OrderViewView from "./components/OrderViewView"
import OrderViewViewDetail from "./components/OrderViewViewDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/orderStatuses',
                name: 'OrderStatusView',
                component: OrderStatusView
            },
            {
                path: '/orderStatuses/:id',
                name: 'OrderStatusViewDetail',
                component: OrderStatusViewDetail
            },
            {
                path: '/menus',
                name: 'MenuView',
                component: MenuView
            },
            {
                path: '/menus/:id',
                name: 'MenuViewDetail',
                component: MenuViewDetail
            },
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/orderProcessings',
                name: 'OrderProcessingManager',
                component: OrderProcessingManager
            },
            {
                path: '/orderProcessings/:id',
                name: 'OrderProcessingDetail',
                component: OrderProcessingDetail
            },

            {
                path: '/orderViews',
                name: 'OrderViewView',
                component: OrderViewView
            },
            {
                path: '/orderViews/:id',
                name: 'OrderViewViewDetail',
                component: OrderViewViewDetail
            },



    ]
})
