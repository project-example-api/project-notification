export interface Notification {
    id: number;
    title: string;
    description: string;
    publication: string;
    visualization: string;
}

export interface ResponseNotifications{
    page: number;
    per_page: number;
    total: number;
    total_pages: number;
    list: Notification[];
} 