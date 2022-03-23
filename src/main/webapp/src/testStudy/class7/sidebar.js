import React, { useState } from "react";
import { Menu, Icon, Segment, Sidebar, Button } from "semantic-ui-react";
import Test from "./test";
const Sidebar1 = () => {
    const [visible, setVisible] = useState(true);

    return (
        <Sidebar.Pushable as={Segment}>
            <Sidebar
                as={Menu}
                animation="push"
                icon="labeled"
                inverted
                vertical
                visible={visible}
                width="wide"
            >
                <Menu.Item as="a">
                    <Icon name="home" />
                    Home
                </Menu.Item>
            </Sidebar>

            <Sidebar.Pusher>
                <Button
                    style={{ cursor: "pointer" }}
                    onClick={() => setVisible(!visible)}
                >
                    Sidebar Btn
                </Button>

                <Test />
            </Sidebar.Pusher>
        </Sidebar.Pushable>
    );
};

export default Sidebar1;
